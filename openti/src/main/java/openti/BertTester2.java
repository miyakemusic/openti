package openti;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.dependency2.RequestRejectedException;
import openti.UserEasyAccess.EnumBertStateModule1;
import openti.UserEasyAccess.EnumBertStateModule2;
import openti.UserEasyAccess.EnumBertsModule1Teststate;
import openti.UserEasyAccess.EnumBertsModule2Teststate;

public class BertTester2 extends BertTester {

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_BERTS_MODULE2_TESTSTATE);
	}
	
	@Override
	protected String stopId() {
		return ID.ID_BERTS_MODULE2_TESTSTATE_STOP;
	}

	@Override
	protected void onIdle(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule2(EnumBertStateModule2.ID_BERT_STATE_MODULE2_IDLE);
	//	properties.setBertsModule2Teststate(EnumBertsModule2Teststate.ID_BERTS_MODULE2_TESTSTATE_STOP);
	}

	@Override
	protected void onSavingFile(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule2(EnumBertStateModule2.ID_BERT_STATE_MODULE2_SAVING);
	}

	@Override
	protected void onAnalyzing(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule2(EnumBertStateModule2.ID_BERT_STATE_MODULE2_ANALYZING);
	}

	@Override
	protected void onTesting(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule2(EnumBertStateModule2.ID_BERT_STATE_MODULE2_TESTING);
	}

	@Override
	protected void onPreparing(UserEasyAccess properties) throws RequestRejectedException {
		properties.setBertStateModule2(EnumBertStateModule2.ID_BERT_STATE_MODULE2_PREPARING);
	}
}
