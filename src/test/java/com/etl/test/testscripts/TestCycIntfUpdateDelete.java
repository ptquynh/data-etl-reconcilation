package com.etl.test.testscripts;
import org.testng.annotations.Test;
import com.etl.common.database.DatabaseUtils;
import com.etl.common.database.ExcelUtils;
import com.codoid.products.exception.FilloException;
import java.util.List;
import com.etl.test.testconfig.TestConfig;
import java.sql.SQLException;
import com.etl.common.Utils;


public class TestCycIntfUpdateDelete extends TestConfig {


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_31__CYC_INTF__CYC_CODE_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_31
		* Test case name:[CYC_INTF][CYC_CODE] Update record data
		* Test Description:Update data record, field CYC_CODE
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, CYCLE_CODE FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CYC_CODE From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CYC_CODE From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, CYCLE_CODE FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_32__CYC_INTF__CYC_NM_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_32
		* Test case name:[CYC_INTF][CYC_NM] Update record data
		* Test Description:Update data record, field CYC_NM
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, CYCLE_NAME FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CYC_NM From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CYC_NM From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, CYCLE_NAME FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_33__CYC_INTF__CYC_STT_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_33
		* Test case name:[CYC_INTF][CYC_STT] Update record data
		* Test Description:Update data record, field CYC_STT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, STATUS FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CYC_STT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CYC_STT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, STATUS FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_34__CYC_INTF__PCS_DT_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_34
		* Test case name:[CYC_INTF][PCS_DT] Update record data
		* Test Description:Update data record, field PCS_DT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, PCS_DT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, PCS_DT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_35__CYC_INTF__PPN_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_35
		* Test case name:[CYC_INTF][PPN_TMS] Update record data
		* Test Description:Update data record, field SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_36__CYC_INTF__CRN_ROW_IND_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_36
		* Test case name:[CYC_INTF][CRN_ROW_IND] Update record data
		* Test Description:Update data record, field CRN_ROW_IND
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, '1' AS CRN_ROW_IND FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CRN_ROW_IND From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CRN_ROW_IND From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, '1' AS CRN_ROW_IND FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_37__CYC_INTF__EFF_FM_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_37
		* Test case name:[CYC_INTF][EFF_FM_TMS] Update record data
		* Test Description:Update data record, field SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_38__CYC_INTF__EFF_TO_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_38
		* Test case name:[CYC_INTF][EFF_TO_TMS] Update record data
		* Test Description:Update data record, field SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID, '2400-01-01' AS EFF_FM_TMS_EXTRACT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="Select UNQ_ID_IN_SRC_STM, SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) AND eff_to_tms = '2400-01-01 23:59:59'";
			String sourceQuery="SELECT CYCLE_ID, '2400-01-01' AS EFF_FM_TMS_EXTRACT FROM CLOSED_CYCLE WHERE CYCLE_ID IN (9599, 1004, 1014, 2275, 3551, 1247, 5126, 4107, 6774) ";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Data Values","Target Testing"})
		public void CYC_INTF_39__CYC_INTF__Updaterecorddata_Checkhistoryrecord() throws SQLException {
		/**
		* Test case ID:CYC_INTF_39
		* Test case name:[CYC_INTF][Update record data] Check history record
		* Test Description:Check history record with SCD type 2
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:Select * From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 4107, 1004, 1014) AND eff_to_tms <> '2400-01-01 23:59:59'
		* Expected Results: Exits history record with SCD type 2
		*/
			String targetQuery="Select * From CYC_INTF where UNQ_ID_IN_SRC_STM IN (9599, 4107, 1004, 1014) AND eff_to_tms <> '2400-01-01 23:59:59'";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Data Values","Target Testing"})
		public void CYC_INTF_40__CYC_INTF_Deleterecorddata() throws SQLException {
		/**
		* Test case ID:CYC_INTF_40
		* Test case name:[CYC_INTF] Delete record data
		* Test Description:Delete record data
		* Precondition:
		* Priority:2
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:Select * From CYC_INTF where UNQ_ID_IN_SRC_STM IN (1247, 5126)
		* Expected Results: 
Update fields: 
		*/
			String targetQuery="Select * From CYC_INTF where UNQ_ID_IN_SRC_STM IN (1247, 5126)";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}
		
}