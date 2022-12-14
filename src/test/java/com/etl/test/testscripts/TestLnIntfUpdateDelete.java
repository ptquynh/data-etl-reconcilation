package com.etl.test.testscripts;
import org.testng.annotations.Test;
import com.etl.common.database.DatabaseUtils;
import com.etl.common.database.ExcelUtils;
import com.codoid.products.exception.FilloException;
import java.util.List;
import com.etl.test.testconfig.TestConfig;
import java.sql.SQLException;
import com.etl.common.Utils;


public class TestLnIntfUpdateDelete extends TestConfig {


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_33__LN_INTF__LN_CODE_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_33
		* Test case name:[LN_INTF][LN_CODE] Update record data
		* Test Description:Update data record, field LN_CODE
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, LANE_CODE FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, LN_CODE From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, LN_CODE From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, LANE_CODE FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_34__LN_INTF__LN_NM_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_34
		* Test case name:[LN_INTF][LN_NM] Update record data
		* Test Description:Update data record, field LN_NM
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, LANE_NAME FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, LN_NM From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, LN_NM From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, LANE_NAME FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_35__LN_INTF__LN_TP_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_35
		* Test case name:[LN_INTF][LN_TP] Update record data
		* Test Description:Update data record, field LN_TP
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, LANE_TYPE FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, LN_TP From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, LN_TP From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, LANE_TYPE FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_36__LN_INTF__LN_STT_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_36
		* Test case name:[LN_INTF][LN_STT] Update record data
		* Test Description:Update data record, field LN_STT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, STATUS FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, LN_STT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, LN_STT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, STATUS FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_37__LN_INTF__TOLL_ID_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_37
		* Test case name:[LN_INTF][TOLL_ID] Update record data
		* Test Description:Update data record, field TOLL_ID
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, TOLL_ID FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, TOLL_ID From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, TOLL_ID From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, TOLL_ID FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_38__LN_INTF__PCS_DT_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_38
		* Test case name:[LN_INTF][PCS_DT] Update record data
		* Test Description:Update data record, field PCS_DT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, PCS_DT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, PCS_DT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_39__LN_INTF__PPN_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_39
		* Test case name:[LN_INTF][PPN_TMS] Update record data
		* Test Description:Update data record, field PPN_TMS
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_40__LN_INTF__CRN_ROW_IND_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_40
		* Test case name:[LN_INTF][CRN_ROW_IND] Update record data
		* Test Description:Update data record, field CRN_ROW_IND
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, '1' AS CRN_ROW_IND FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CRN_ROW_IND From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CRN_ROW_IND From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, '1' AS CRN_ROW_IND FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_41__LN_INTF__EFF_FM_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_41
		* Test case name:[LN_INTF][EFF_FM_TMS] Update record data
		* Test Description:Update data record, field EFF_FM_TMS
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_42__LN_INTF__EFF_TO_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_42
		* Test case name:[LN_INTF][EFF_TO_TMS] Update record data
		* Test Description:Update data record, field EFF_TO_TMS
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, '2400-01-01' AS EFF_FM_TMS_EXTRACT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,392,393,394,395,396,398,391) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT TOLL_LANE_ID, '2400-01-01' AS EFF_FM_TMS_EXTRACT FROM TOLL_LANE WHERE TOLL_LANE_ID IN (390,392,393,394,395,396,398,391) ";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Target Testing"})
		public void LN_INTF_43__LN_INTF__Updaterecorddata_Checkhistoryrecord() throws SQLException {
		/**
		* Test case ID:LN_INTF_43
		* Test case name:[LN_INTF][Update record data] Check history record
		* Test Description:Check history record with SCD type 2
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:Select * From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,395,396,391) AND eff_to_tms <> '2400-01-01 23:59:59'
		* Expected Results: Exits history record with SCD type 2
		*/
			String targetQuery="Select * From LN_INTF where UNQ_ID_IN_SRC_STM IN (390,395,396,391) AND eff_to_tms <> '2400-01-01 23:59:59'";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Data Values","Target Testing"})
		public void LN_INTF_44__LN_INTF_Deleterecorddata() throws SQLException {
		/**
		* Test case ID:LN_INTF_44
		* Test case name:[LN_INTF] Delete record data
		* Test Description:Delete record data
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:Select * From LN_INTF where UNQ_ID_IN_SRC_STM IN (389,398)
		* Expected Results: 
Update fields: IRGLR_CODE, IRGLR_NM to null
		*/
			String targetQuery="Select * From LN_INTF where UNQ_ID_IN_SRC_STM IN (389,398)";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}
		
}