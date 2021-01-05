package openti.server;

import java.io.File;
import java.util.List;
import java.util.Map;
import jp.silverbullet.core.BlobStore;
import jp.silverbullet.core.MyFileUtils;
import jp.silverbullet.core.PropertyGetter;
import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.DependencyEngine;
import jp.silverbullet.core.dependency2.DependencyListener;
import jp.silverbullet.core.dependency2.DependencySpecHolder;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.ChartProperty;
import jp.silverbullet.core.property2.PropertyHolder2;
import jp.silverbullet.core.property2.RuntimeProperty;
import jp.silverbullet.core.property2.RuntimePropertyStore;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.LocalPersistent;
import jp.silverbullet.core.sequncer.Sequencer;
import jp.silverbullet.core.sequncer.SequencerListener;
import jp.silverbullet.core.sequncer.SystemAccessor;
import jp.silverbullet.core.sequncer.UserSequencer;
import jp.silverbullet.core.ui.part2.UiBuilder;
import jp.silverbullet.dev.PersistentHolder;
import openti.ID;
import openti.test.SimHardware;

public abstract class StandaloneDomainModel extends AbstractTesterModel {
	public static void main(String[] arg) {
//		new StandaloneOtdrModel("C:\\Users\\miyak\\git\\silverbullet\\silverbullet\\persistent\\Native1602326588229\\miyake_otdr.zip");
	}
	
	private RuntimePropertyStore propertyStore;
	private Sequencer sequencer;
	private PropertyHolder2 propertiesHolder2 = new PropertyHolder2();
	private DependencySpecHolder dependencySpecHolder2 = new DependencySpecHolder();
	private PersistentHolder persistentHolder = new PersistentHolder();
	private DependencyEngine dependencyEngine;
	private BlobStore blobStore;
	private UiBuilder uiBuilder;
	private String currentFilename;
	public StandaloneDomainModel(String filename, List<UserSequencer> sequencers) {
		uiBuilder = new UiBuilder();
		
		this.currentFilename = filename;
		loadFiles(filename);
		
		propertyStore = new RuntimePropertyStore(propertiesHolder2);

		PropertyGetter getter = new PropertyGetter () {
			public RuntimeProperty getProperty(String id) {
				return propertyStore.get(id);
			}
			
			public RuntimeProperty getProperty(String id, int index) {
				return propertyStore.get(id, index);
			}
		};
		
		dependencyEngine = new DependencyEngine(getter) {
			protected DependencySpecHolder getSpecHolder() {
				return dependencySpecHolder2;
			}
		};
		
		SimHardware hardware = new SimHardware();
		blobStore = new BlobStore();
		
		sequencer = new Sequencer() {
			@Override
			protected RuntimePropertyStore getPropertiesStore() {
				return propertyStore;
			}

			@Override
			protected DependencyEngine getDependency() {
				return dependencyEngine;
			}

			@Override
			protected RegisterAccessor getRegisterAccessor() {
				return hardware;
			}

			@Override
			protected SystemAccessor getSystemAccessor() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected BlobStore getBlobStore() {
				return blobStore;
			}
		};
		
		this.dependencyEngine.addDependencyListener(new DependencyListener() {
			@Override
			public boolean confirm(String history) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onResult(Map<String, List<ChangedItemValue>> changedHistory) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted(String message) {
				listeners.forEach(listener -> listener.onUpdate(message));
			}

			@Override
			public void onStart(Id id, String value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onRejected(Id id, String message) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProgress(List<String> log) {
				// TODO Auto-generated method stub
				
			}
		});
		
		sequencers.forEach(userSeq -> sequencer.addUserSequencer(userSeq));
		sequencer.addUserSequencer(new LocalPersistent(persistentHolder, this.propertyStore, this.blobStore) {

			@Override
			protected String getStorePath() {
				return "store/";
			}
			
		});
		sequencer.addSequencerListener(new SequencerListener() {
			@Override
			public void onChangedBySystem(Id id, String value) {
				if (!id.getSource().equals(SocketServer.FromServer)) {
					if (blobStore.stores(id.getId())) {
						onBlobChanged(id.getId(), blobStore.get(id.getId()), value);
					}
					else {
						onChanged(id.getId(), value);
					}
				}
			}

			@Override
			public void onChangedByUser(Id id, String value) {
				if (!id.getSource().equals(SocketServer.FromServer)) {
					onChanged(id.getId(), value);
				}
			}
		});
	}

	abstract protected void onChanged(String id, String value);
	abstract protected void onBlobChanged(String id, Object value, String name);
	
	private void loadFiles(String filename) {
		if (new File(filename).exists()) {
			MyFileUtils.unzip(filename, "tmp");
			propertiesHolder2.load("tmp/" + MyFileUtils.ID_DEF_JSON);
			dependencySpecHolder2.load("tmp/" + MyFileUtils.DEPENDENCYSPEC3_XML);
			uiBuilder.loadJson("tmp/" + MyFileUtils.UIBUILDER2);
			persistentHolder.load("tmp/");
		}
	}

	@Override
	public void requestChange(String id, String value) {
		try {
			this.sequencer.requestChange(new Id(id), value, true);
		} catch (RequestRejectedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValue(String id) {
		if (ID.ID_TRACE.equals(id)) {
			ChartProperty chartContent = (ChartProperty)this.blobStore.get(id);
			StringBuffer buf  = new StringBuffer();
			for (String s: chartContent.getY()) {
				buf.append(s+",");
			}
			return buf.toString();
		}
		return this.propertyStore.get(id).getCurrentValue();
	}

	public RuntimePropertyStore getPropertyStore() {
		return propertyStore;
	}

	public Sequencer getSequencer() {
		return sequencer;
	}

	public BlobStore getBlobStore() {
		return blobStore;
	}

	public UiBuilder getUiBuilder() {
		return this.uiBuilder;
	}

	public void reload() {
		this.loadFiles(this.currentFilename);
	}

	public void handle(Map<String, List<ChangedItemValue>> changed) {
		for (String id : changed.keySet()) {
			List<ChangedItemValue> v = changed.get(id);
			for (ChangedItemValue civ : v) {
				try {
					id = RuntimeProperty.convertSimpleId(id);
					this.sequencer.requestChange(new Id(id, 0, SocketServer.FromServer), civ.getValue());
				} catch (RequestRejectedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	

}
