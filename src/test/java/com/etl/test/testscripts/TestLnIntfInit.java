package com.etl.test.testscripts;
import org.testng.annotations.Test;
import com.etl.common.database.DatabaseUtils;
import com.etl.common.database.ExcelUtils;
import com.codoid.products.exception.FilloException;
import java.util.List;
import com.etl.test.testconfig.TestConfig;
import java.sql.SQLException;
import com.etl.common.Utils;


public class TestLnIntfInit extends TestConfig {


		@Test(priority=1,groups={"Metadata","Reconcilation Testing"})
		public void LN_INTF_1__LN_INTF_VerifyMetadata() throws SQLException,FilloException {
		/**
		* Test case ID:LN_INTF_1
		* Test case name:[LN_INTF] Verify Metadata
		* Test Description:Check target schema table and data type columns target
		* Precondition:
		* Priority:1
		* Labels:Metadata
		* SourceDB: EXCEL_FILE
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT * FROM LN_INTF
		* 2. Run Target Query:DESCRIBE INTF.LN_INTF
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="DESCRIBE INTF.LN_INTF";
			String sourceQuery="SELECT * FROM LN_INTF";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=ExcelUtils.getColumnValues(sourceQuery,srcExcelConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Record Counts","Reconcilation Testing"})
		public void LN_INTF_2__TOLL_LANE__LN_INTF_VerifyRecordCounts() throws SQLException {
		/**
		* Test case ID:LN_INTF_2
		* Test case name:[TOLL_LANE][LN_INTF]  VerifyRecord Counts
		* Test Description:Verify record counts between source data and target data are same
		* Precondition:
		* Priority:1
		* Labels:Record Counts
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT COUNT(*)  AS NUM_RECORDS FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1
		* 2. Run Target Query:SELECT COUNT(*) AS NUM_RECORDS FROM INTF.LN_INTF
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT COUNT(*) AS NUM_RECORDS FROM INTF.LN_INTF";
			String sourceQuery="SELECT COUNT(*)  AS NUM_RECORDS FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_3__LN_INTF__UNQ_ID_IN_SRC_STM_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_3
		* Test case name:[LN_INTF][UNQ_ID_IN_SRC_STM]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.TOLL_LANE_ID and target data: INTF.LN_INTF.UNQ_ID_IN_SRC_STM with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_4__LN_INTF__LN_CODE_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_4
		* Test case name:[LN_INTF][LN_CODE]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.LANE_CODE and target data: INTF.LN_INTF.LN_CODE with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, LANE_CODE FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, LN_CODE FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, LN_CODE FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, LANE_CODE FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_5__LN_INTF__LN_NM_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_5
		* Test case name:[LN_INTF][LN_NM]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.LANE_NAME and target data: INTF.LN_INTF.LN_NM with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, LANE_NAME FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, LN_NM FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, LN_NM FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, LANE_NAME FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_6__LN_INTF__LN_TP_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_6
		* Test case name:[LN_INTF][LN_TP]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.LANE_TYPE and target data: INTF.LN_INTF.LN_TP with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, LANE_TYPE FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, LN_TP FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, LN_TP FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, LANE_TYPE FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_7__LN_INTF__LN_STT_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_7
		* Test case name:[LN_INTF][LN_STT]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.STATUS and target data: INTF.LN_INTF.LN_STT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, STATUS FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, LN_STT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, LN_STT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, STATUS FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_8__LN_INTF__TOLL_ID_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_8
		* Test case name:[LN_INTF][TOLL_ID]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.TOLL_ID and target data: INTF.LN_INTF.TOLL_ID with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, TOLL_ID FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, TOLL_ID FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, TOLL_ID FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, TOLL_ID FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_9__LN_INTF__SRC_STM_CODE_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_9
		* Test case name:[LN_INTF][SRC_STM_CODE]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.'TOLL_LANE' AS SRC_STM_CODE and target data: INTF.LN_INTF.SRC_STM_CODE with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, 'TOLL_LANE' AS SRC_STM_CODE FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SRC_STM_CODE FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SRC_STM_CODE FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, 'TOLL_LANE' AS SRC_STM_CODE FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_10__LN_INTF__SRC_STM_NM_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_10
		* Test case name:[LN_INTF][SRC_STM_NM]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.'TOLL_LANE' AS SRC_STM_NM and target data: INTF.LN_INTF.SRC_STM_NM with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, 'TOLL_LANE' AS SRC_STM_NM FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SRC_STM_NM FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SRC_STM_NM FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, 'TOLL_LANE' AS SRC_STM_NM FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_11__LN_INTF__PCS_DT_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_11
		* Test case name:[LN_INTF][PCS_DT]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT and target data: INTF.LN_INTF.PCS_DT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, PCS_DT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, PCS_DT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_12__LN_INTF__PPN_TMS_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_12
		* Test case name:[LN_INTF][PPN_TMS]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT and target data: INTF.LN_INTF.SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_13__LN_INTF__CRN_ROW_IND_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_13
		* Test case name:[LN_INTF][CRN_ROW_IND]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.'1' AS CRN_ROW_IND and target data: INTF.LN_INTF.CRN_ROW_IND with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, '1' AS CRN_ROW_IND FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, CRN_ROW_IND FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, CRN_ROW_IND FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, '1' AS CRN_ROW_IND FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_14__LN_INTF_EFF_FM_TMS_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_14
		* Test case name:[LN_INTF]EFF_FM_TMS]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.TOLL_LANE.TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT and target data: INTF.LN_INTF.SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void LN_INTF_15__LN_INTF__EFF_TO_TMS_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:LN_INTF_15
		* Test case name:[LN_INTF][EFF_TO_TMS]  VerifyData Values
		* Test Description:Mapping rule by: FIX value '2400-01-01 23:59:59'
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT TOLL_LANE_ID, '2400-01-01' AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT FROM INTF.LN_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT TOLL_LANE_ID, '2400-01-01' AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.TOLL_LANE WHERE STATUS = 1 ORDER BY TOLL_LANE_ID";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<String> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<String> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<String> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Uniqueness","Target Testing"})
		public void LN_INTF_16__LN_INTF__UNQ_ID_IN_SRC_STM_VerifyUniqueness() throws SQLException {
		/**
		* Test case ID:LN_INTF_16
		* Test case name:[LN_INTF][UNQ_ID_IN_SRC_STM]  VerifyUniqueness
		* Test Description:Verify the field is not duplicated
		* Precondition:
		* Priority:2
		* Labels:Uniqueness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, count(*) as frequency FROM INTF.LN_INTF WHERE UNQ_ID_IN_SRC_STM is not null or UNQ_ID_IN_SRC_STM ='' or UNQ_ID_IN_SRC_STM <=0 GROUP BY UNQ_ID_IN_SRC_STM HAVING count(*)>1
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, count(*) as frequency FROM INTF.LN_INTF WHERE UNQ_ID_IN_SRC_STM is not null or UNQ_ID_IN_SRC_STM ='' or UNQ_ID_IN_SRC_STM <=0 GROUP BY UNQ_ID_IN_SRC_STM HAVING count(*)>1";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Uniqueness","Target Testing"})
		public void LN_INTF_17__LN_INTF__LN_ANCHOR_ID_VerifyUniqueness() throws SQLException {
		/**
		* Test case ID:LN_INTF_17
		* Test case name:[LN_INTF][LN_ANCHOR_ID]  VerifyUniqueness
		* Test Description:Verify the field is not duplicated
		* Precondition:
		* Priority:2
		* Labels:Uniqueness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT LN_ANCHOR_ID, count(*) as frequency FROM INTF.LN_INTF GROUP BY LN_ANCHOR_ID HAVING count(*)>1
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT LN_ANCHOR_ID, count(*) as frequency FROM INTF.LN_INTF GROUP BY LN_ANCHOR_ID HAVING count(*)>1";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_18__LN_INTF__UNQ_ID_IN_SRC_STM_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_18
		* Test case name:[LN_INTF][UNQ_ID_IN_SRC_STM]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE UNQ_ID_IN_SRC_STM is null or UNQ_ID_IN_SRC_STM =''  or UNQ_ID_IN_SRC_STM <=0
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE UNQ_ID_IN_SRC_STM is null or UNQ_ID_IN_SRC_STM =''  or UNQ_ID_IN_SRC_STM <=0";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_19__LN_INTF__PCS_DT_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_19
		* Test case name:[LN_INTF][PCS_DT]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE PCS_DT is null or PCS_DT =''
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE PCS_DT is null or PCS_DT =''";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_20__LN_INTF__PPN_TMS_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_20
		* Test case name:[LN_INTF][PPN_TMS]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE PPN_TMS is null or PPN_TMS =''
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE PPN_TMS is null or PPN_TMS =''";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_21__LN_INTF__SRC_STM_CODE_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_21
		* Test case name:[LN_INTF][SRC_STM_CODE]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE SRC_STM_CODE is null or SRC_STM_CODE =''
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE SRC_STM_CODE is null or SRC_STM_CODE =''";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_22__LN_INTF__SRC_STM_NM_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_22
		* Test case name:[LN_INTF][SRC_STM_NM]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE SRC_STM_NM is null or SRC_STM_NM =''
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE SRC_STM_NM is null or SRC_STM_NM =''";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_23__LN_INTF__CRN_ROW_IND_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_23
		* Test case name:[LN_INTF][CRN_ROW_IND]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE CRN_ROW_IND is null or CRN_ROW_IND =''  or CRN_ROW_IND <=0
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE CRN_ROW_IND is null or CRN_ROW_IND =''  or CRN_ROW_IND <=0";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_24__LN_INTF__EFF_FM_TMS_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_24
		* Test case name:[LN_INTF][EFF_FM_TMS]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE EFF_FM_TMS is null or EFF_FM_TMS =''
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE EFF_FM_TMS is null or EFF_FM_TMS =''";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void LN_INTF_25__LN_INTF__EFF_TO_TMS_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:LN_INTF_25
		* Test case name:[LN_INTF][EFF_TO_TMS]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.LN_INTF WHERE EFF_TO_TMS is null or EFF_TO_TMS =''
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.LN_INTF WHERE EFF_TO_TMS is null or EFF_TO_TMS =''";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_26__LN_INTF__SRC_STM_CODE_CheckValidity() throws SQLException {
		/**
		* Test case ID:LN_INTF_26
		* Test case name:[LN_INTF][SRC_STM_CODE] Check Validity
		* Test Description:Field SRC_STM_CODE  
only 1 value is 'TOLL_LANE'
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SRC_STM_CODE FROM LN_INTF WHERE SRC_STM_CODE <> 'TOLL_LANE'
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SRC_STM_CODE FROM LN_INTF WHERE SRC_STM_CODE <> 'TOLL_LANE'";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_27__LN_INTF__SRC_STM_NM_CheckValidity() throws SQLException {
		/**
		* Test case ID:LN_INTF_27
		* Test case name:[LN_INTF][SRC_STM_NM] Check Validity
		* Test Description:Field SRC_STM_NM  
only 1 value is 'TOLL_LANE'
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, SRC_STM_NM FROM LN_INTF WHERE SRC_STM_NM <> 'TOLL_LANE'
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, SRC_STM_NM FROM LN_INTF WHERE SRC_STM_NM <> 'TOLL_LANE'";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_28__LN_INTF__PCS_DT_Checkvalue() throws SQLException {
		/**
		* Test case ID:LN_INTF_28
		* Test case name:[LN_INTF] [PCS_DT ] Check value
		* Test Description:Field PCS_DT is less than or equal to current date
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, PCS_DT FROM LN_INTF WHERE PCS_DT > CURRENT_DATE
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, PCS_DT FROM LN_INTF WHERE PCS_DT > CURRENT_DATE";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_29__LN_INTF__CRN_ROW_IND_CheckValidity() throws SQLException {
		/**
		* Test case ID:LN_INTF_29
		* Test case name:[LN_INTF][CRN_ROW_IND] Check Validity
		* Test Description:Field CRN_ROW_IND in (0,1)
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, CRN_ROW_IND FROM LN_INTF WHERE CRN_ROW_IND NOT IN (0,1)
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, CRN_ROW_IND FROM LN_INTF WHERE CRN_ROW_IND NOT IN (0,1)";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_30__LN_INTF__CRN_ROW_IND_EFF_TO_TMS_CheckValidity() throws SQLException {
		/**
		* Test case ID:LN_INTF_30
		* Test case name:[LN_INTF][CRN_ROW_IND_EFF_TO_TMS] Check Validity
		* Test Description:For records with EFF_TO_TMS = '2400-01-01 23:59:59', field CRN_ROW_IND must be equal to 1
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, EFF_TO_TMS, CRN_ROW_IND FROM LN_INTF WHERE EFF_TO_TMS = '2400-01-01 23:59:59' AND CRN_ROW_IND <> 1
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, EFF_TO_TMS, CRN_ROW_IND FROM LN_INTF WHERE EFF_TO_TMS = '2400-01-01 23:59:59' AND CRN_ROW_IND <> 1";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_31__LN_INTF__EFF_FM_TMS__EFF_TO_TMS_Checkvalidity() throws SQLException {
		/**
		* Test case ID:LN_INTF_31
		* Test case name:[LN_INTF][EFF_FM_TMS__EFF_TO_TMS] Check validity
		* Test Description:At 1 record: EFF_FM_TMS>= EFF_TO_TMS
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, EFF_TO_TMS, CRN_ROW_IND FROM LN_INTF WHERE EFF_FM_TMS > EFF_TO_TMS
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, EFF_TO_TMS, CRN_ROW_IND FROM LN_INTF WHERE EFF_FM_TMS > EFF_TO_TMS";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Validity","Target Testing"})
		public void LN_INTF_32__LN_INTF__EFF_FM_TMS__EFF_TO_TMS_Checkvalue() throws SQLException {
		/**
		* Test case ID:LN_INTF_32
		* Test case name:[LN_INTF][EFF_FM_TMS__EFF_TO_TMS] Check value
		* Test Description:EFF_TO_TMS of previous record = EFF_FM_TMS of following record
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:WITH LN_INTF_CONVER AS ( SELECT ROW_NUMBER () OVER (PARTITION BY UNQ_ID_IN_SRC_STM ORDER BY EFF_FM_TMS ASC) AS RANK 	, UNQ_ID_IN_SRC_STM 	, EFF_FM_TMS 	, EFF_TO_TMS FROM LN_INTF ) SELECT a.UNQ_ID_IN_SRC_STM, a.EFF_FM_TMS, a.EFF_TO_TMS, b.EFF_FM_TMS, b.EFF_TO_TMS FROM LN_INTF_CONVER a  JOIN LN_INTF_CONVER b ON a.UNQ_ID_IN_SRC_STM = b.UNQ_ID_IN_SRC_STM AND a.RANK = b.RANK + 1 WHERE a.EFF_FM_TMS <> b.EFF_TO_TMS
		* Expected Results: Not return any values
		*/
			String targetQuery="WITH LN_INTF_CONVER AS ( SELECT ROW_NUMBER () OVER (PARTITION BY UNQ_ID_IN_SRC_STM ORDER BY EFF_FM_TMS ASC) AS RANK 	, UNQ_ID_IN_SRC_STM 	, EFF_FM_TMS 	, EFF_TO_TMS FROM LN_INTF ) SELECT a.UNQ_ID_IN_SRC_STM, a.EFF_FM_TMS, a.EFF_TO_TMS, b.EFF_FM_TMS, b.EFF_TO_TMS FROM LN_INTF_CONVER a  JOIN LN_INTF_CONVER b ON a.UNQ_ID_IN_SRC_STM = b.UNQ_ID_IN_SRC_STM AND a.RANK = b.RANK + 1 WHERE a.EFF_FM_TMS <> b.EFF_TO_TMS";
			List<String> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}
		
}