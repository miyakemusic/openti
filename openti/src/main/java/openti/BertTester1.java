package openti;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.KeyValue;
import openti.SilverbulletUserEasyAccess.EnumBertStateModule1;
import openti.SilverbulletUserEasyAccess.EnumBertsModule1Teststate;

public class BertTester1 extends BertTester {

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_BERTS_MODULE1_TESTSTATE, ID.ID_BERTS_TEST_CONTROL, ID.ID_START_ACTION, ID.ID_STOP_ACTION);
	}


	@Override
	protected void onIdle(SilverbulletUserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_IDLE);
		properties.setBertsModule1Teststate(EnumBertsModule1Teststate.ID_BERTS_MODULE1_TESTSTATE_STOP);
	}

	@Override
	protected void onSavingFile(SilverbulletUserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_SAVING);
	}

	@Override
	protected void onAnalyzing(SilverbulletUserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_ANALYZING);
	}

	@Override
	protected void onTesting(SilverbulletUserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_TESTING);
	}

	@Override
	protected void onPreparing(SilverbulletUserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_PREPARING);
	}


	@Override
	protected List<KeyValue> startIds() {
		return Arrays.asList(
				new KeyValue(ID.ID_BERTS_TEST_CONTROL, ID.ID_BERTS_TEST_CONTROL_START),
				new KeyValue(ID.ID_BERTS_MODULE1_TESTSTATE, ID.ID_BERTS_MODULE1_TESTSTATE_START),
				new KeyValue(ID.ID_START_ACTION, "")
				);
	}


	@Override
	protected List<KeyValue> stopIds() {
		return Arrays.asList(
				new KeyValue(ID.ID_BERTS_TEST_CONTROL, ID.ID_BERTS_TEST_CONTROL_STOP),
				new KeyValue(ID.ID_BERTS_MODULE1_TESTSTATE, ID.ID_BERTS_MODULE1_TESTSTATE_STOP),
				new KeyValue(ID.ID_STOP_ACTION, "")
				);
	}

}
