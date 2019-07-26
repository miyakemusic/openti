package openti;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.web.KeyValue;
import openti.UserEasyAccess.EnumBertStateModule1;
import openti.UserEasyAccess.EnumBertsModule1Teststate;

public class BertTester1 extends BertTester {

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_BERTS_MODULE1_TESTSTATE, ID.ID_BERTS_TEST_CONTROL, ID.ID_START_ACTION, ID.ID_STOP_ACTION);
	}


	@Override
	protected void onIdle(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_IDLE);
		properties.setBertsModule1Teststate(EnumBertsModule1Teststate.ID_BERTS_MODULE1_TESTSTATE_STOP);
	}

	@Override
	protected void onSavingFile(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_SAVING);
	}

	@Override
	protected void onAnalyzing(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_ANALYZING);
	}

	@Override
	protected void onTesting(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule1(EnumBertStateModule1.ID_BERT_STATE_MODULE1_TESTING);
	}

	@Override
	protected void onPreparing(UserEasyAccess properties) throws RequestRejectedException {
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