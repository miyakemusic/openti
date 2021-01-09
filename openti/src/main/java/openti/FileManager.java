package openti;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.SvFileException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.SystemAccessor.DialogAnswer;
import jp.silverbullet.core.sequncer.UserSequencer;
import jp.silverbullet.dev.ControlObject;
import jp.silverbullet.core.property2.TableProperty;
import openti.SilverbulletUserEasyAccess.EnumBertsState;
import openti.SilverbulletUserEasyAccess.EnumFileFilter;

abstract class ActionManager {

	public ActionManager(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed) {
		SilverbulletUserEasyAccess properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		for (String id2 : changed.keySet()) {
			Id id = new Id(id2);
			handle(id, changed.get(id2), properties);
		}
	}

	abstract protected void handle(Id id, List<ChangedItemValue> list, SilverbulletUserEasyAccess properties);

}

public class FileManager implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {

		new ActionManager(model, changed) {
			@Override
			protected void handle(Id id, List<ChangedItemValue> list, SilverbulletUserEasyAccess properties) {
				if (id.getId().equals(ID.ID_FILE_LIST_UPDATE) || id.getId().equals(ID.ID_FILE_FOLDER)
						|| id.getId().equals(ID.ID_FILE_FILTER)) {
					try {
						updateFileList(model);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
				else if (id.getId().equals(ID.ID_FILE_LIST)){
					String str = properties.getFileList();
					TableProperty obj = TableProperty.read(str);//new ObjectMapper().readValue(str, JsTableContent.class);
					//System.out.println(obj.selectedRow);
					try {
						if (obj.getData().size() > obj.getSelectedRow()) {
							properties.setFileName(obj.getSelectedData().get(0));
						}
					} catch (RequestRejectedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (id.getId().equals(ID.ID_FILE_SAVE)) {
					
					try {
						
						String path = properties.getFileFolder() + "/" + properties.getFileName();
						if (Files.exists(Paths.get(path))) {
							if (model.getSystem().dialog("File exists, Overwrite?\n" + properties.getFileName()).compareTo(DialogAnswer.OK) != 0) {
								return;
							}
						}
						properties.setBertsState(EnumBertsState.ID_BERTS_STATE_SAVING_FILE);
						model.getSystem().saveProperties(path);
						model.getSystem().message("Saved", new ControlObject().ok(), "");
						Thread.sleep(1000);
						properties.setBertsState(EnumBertsState.ID_BERTS_STATE_IDLE);
					} catch (SvFileException | RequestRejectedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (id.getId().equals(ID.ID_FILE_LOAD)) {
					try {
						model.getSystem().loadProperties(properties.getFileFolder() + "/" + properties.getFileName());
						model.getSystem().message("File Loaded.", new ControlObject().ok(), "");
					} catch (SvFileException e) {
						model.getSystem().message("Cannot load the file.", new ControlObject().ok(), "");
						e.printStackTrace();
					}
				}
			}

		};
	}

	protected void updateFileList(SvHandlerModel model) throws JsonParseException, JsonMappingException, IOException {
		String value = model.getEasyAccessInterface().getCurrentValue(ID.ID_FILE_LIST);
		TableProperty tableContent = new TableProperty();
		if (!value.isEmpty()) {
			try {
				tableContent = new ObjectMapper().readValue(value, TableProperty.class);//new JsTableContent();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		tableContent.structureChanged = true;
		tableContent.headers = Arrays.asList("Name", "Modified", "Size");
		
		SilverbulletUserEasyAccess properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		File folder = new File(properties.getFileFolder());
		
		tableContent.clear();
		tableContent.dataChanged = true;
		for (File file : folder.listFiles()) {
			boolean qual = false;
			String suffix = model.getEasyAccessInterface().getSelectedListTitle(ID.ID_FILE_FILTER);
			if (properties.getFileFilter().compareTo(EnumFileFilter.ID_FILE_FILTER_ALL) == 0) {
				qual = true;
			}
			else if (file.getName().toUpperCase().endsWith("." + suffix.toUpperCase())) {
				qual = true;
			}
			if (!qual) {
				continue;
			}
			List<String> line = Arrays.asList(file.getName(), new Date(file.lastModified()).toString(), createSize(file));
			tableContent.addRow(line);
		}
		try {
			model.getEasyAccessInterface().requestChange(new Id(ID.ID_FILE_LIST), new ObjectMapper().writeValueAsString(tableContent));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (RequestRejectedException e) {
			e.printStackTrace();
		}
	}


	private String createSize(File file) {
		if (file.length() < 1024) {
			return String.valueOf(file.length()) + "B";
		}
		return String.valueOf(file.length()/1024) + "KB";
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_FILE_LIST_UPDATE, ID.ID_FILE_FOLDER, ID.ID_FILE_LIST, ID.ID_FILE_FILTER, ID.ID_FILE_LOAD,
				ID.ID_FILE_SAVE);
	}

}
