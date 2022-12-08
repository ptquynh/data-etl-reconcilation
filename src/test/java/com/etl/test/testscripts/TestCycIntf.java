package com.etl.test.testscripts;
import org.testng.annotations.Test;
import com.etl.common.database.DatabaseUtils;
import com.etl.common.database.ExcelUtils;
import com.codoid.products.exception.FilloException;
import java.util.List;
import com.etl.test.testconfig.TestConfig;
import java.sql.SQLException;
import com.etl.common.Utils;


public class TestCycIntf extends TestConfig {


		@Test(priority=1,groups={"Metadata","Reconcilation Testing"})
		public void CYC_INTF_1__CYC_INTF_VerifyMetadata() throws SQLException,FilloException {
		/**
		* Test case ID:CYC_INTF_1
		* Test case name:[CYC_INTF] Verify Metadata
		* Test Description:Verify Target Table schema
		* Precondition:
		* Priority:1
		* Labels:Metadata
		* SourceDB: EXCEL_FILE
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT * FROM CYC_INTF
		* 2. Run Target Query:DESCRIBE INTF.CYC_INTF
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="DESCRIBE INTF.CYC_INTF";
			String sourceQuery="SELECT * FROM CYC_INTF";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=ExcelUtils.getColumnValues(sourceQuery,srcExcelConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_2__CYC_INTF__UNQ_ID_IN_SRC_STM_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_2
		* Test case name:[CYC_INTF][UNQ_ID_IN_SRC_STM]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.CYCLE_ID and target data: INTF.CYC_INTF.UNQ_ID_IN_SRC_STM with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_3__CYC_INTF__CYC_CODE_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_3
		* Test case name:[CYC_INTF][CYC_CODE]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.CYCLE_CODE and target data: INTF.CYC_INTF.CYC_CODE with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,CYCLE_CODE FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,CYC_CODE FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,CYC_CODE FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,CYCLE_CODE FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_4__CYC_INTF__CYC_NM_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_4
		* Test case name:[CYC_INTF][CYC_NM]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.CYCLE_NAME and target data: INTF.CYC_INTF.CYC_NM with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,CYCLE_NAME FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,CYC_NM FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,CYC_NM FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,CYCLE_NAME FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_5__CYC_INTF__CYC_STT_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_5
		* Test case name:[CYC_INTF][CYC_STT]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.STATUS and target data: INTF.CYC_INTF.CYC_STT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,STATUS FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,CYC_STT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,CYC_STT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,STATUS FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_6__CYC_INTF__SRC_STM_CODE_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_6
		* Test case name:[CYC_INTF][SRC_STM_CODE]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.'CYCLE' AS SRC_STM_CODE  and target data: INTF.CYC_INTF.SRC_STM_CODE with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,'CYCLE' AS SRC_STM_CODE  FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,SRC_STM_CODE FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,SRC_STM_CODE FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,'CYCLE' AS SRC_STM_CODE  FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_7__CYC_INTF__SRC_STM_NM_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_7
		* Test case name:[CYC_INTF][SRC_STM_NM]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.'CLOSED_CYCLE' AS SRC_STM_NM and target data: INTF.CYC_INTF.SRC_STM_NM with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,'CLOSED_CYCLE' AS SRC_STM_NM FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,SRC_STM_NM FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,SRC_STM_NM FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,'CLOSED_CYCLE' AS SRC_STM_NM FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_8__CYC_INTF__PCS_DT_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_8
		* Test case name:[CYC_INTF][PCS_DT]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT and target data: INTF.CYC_INTF.PCS_DT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,PCS_DT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,PCS_DT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,TO_CHAR(to_date(CURRENT_DATE),'yyyy-mm-dd') AS PCS_DT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_9__CYC_INTF__PPN_TMS_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_9
		* Test case name:[CYC_INTF][PPN_TMS]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT and target data: INTF.CYC_INTF.SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,SUBSTR(PPN_TMS,0,4) AS PPN_TMS_EXTRACT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,REGEXP_SUBSTR(((SYSDATE - TO_DATE('1970-01-01', 'yyyy-MM-dd')) * (24 * 60 * 60 * 1000)),'^[0-9,]{4}') AS PPN_TMS_EXTRACT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_10__CYC_INTF_EFF_FM_TMS_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_10
		* Test case name:[CYC_INTF]EFF_FM_TMS]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT and target data: INTF.CYC_INTF.SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,SUBSTR(EFF_FM_TMS,0,10) AS EFF_FM_TMS_EXTRACT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=1,groups={"Data Values","Reconcilation Testing"})
		public void CYC_INTF_11__CYC_INTF__EFF_TO_TMS_VerifyDataValues() throws SQLException {
		/**
		* Test case ID:CYC_INTF_11
		* Test case name:[CYC_INTF][EFF_TO_TMS]  VerifyData Values
		* Test Description:Verify data values between source data:  RATING_OWNER.CLOSED_CYCLE.'2400-01-01' AS EFF_FM_TMS_EXTRACT and target data: INTF.CYC_INTF.SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT with transformation logic: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Data Values
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT CYCLE_ID,'2400-01-01' AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM,SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM,SUBSTR(EFF_TO_TMS,0,10) AS EFF_TO_TMS_EXTRACT FROM INTF.CYC_INTF ORDER BY UNQ_ID_IN_SRC_STM";
			String sourceQuery="SELECT CYCLE_ID,'2400-01-01' AS EFF_FM_TMS_EXTRACT FROM RATING_OWNER.CLOSED_CYCLE ORDER BY CYCLE_ID";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}


		@Test(priority=2,groups={"Completeness","Target Testing"})
		public void CYC_INTF_12__CYC_INTF__UNQ_ID_IN_SRC_STM_VerifyCompleteness() throws SQLException {
		/**
		* Test case ID:CYC_INTF_12
		* Test case name:[CYC_INTF][UNQ_ID_IN_SRC_STM]  VerifyCompleteness
		* Test Description:Verify the field is not null or empty
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: N/A
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT * FROM INTF.CYC_INTF WHERE UNQ_ID_IN_SRC_STM is null or UNQ_ID_IN_SRC_STM =''  or UNQ_ID_IN_SRC_STM <=0
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT * FROM INTF.CYC_INTF WHERE UNQ_ID_IN_SRC_STM is null or UNQ_ID_IN_SRC_STM =''  or UNQ_ID_IN_SRC_STM <=0";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=2,groups={"Uniqueness","Target Testing"})
		public void CYC_INTF_13__CYC_INTF__UNQ_ID_IN_SRC_STM_VerifyUniqueness() throws SQLException {
		/**
		* Test case ID:CYC_INTF_13
		* Test case name:[CYC_INTF][UNQ_ID_IN_SRC_STM]  VerifyUniqueness
		* Test Description:Verify the field is not duplicated
		* Precondition:
		* Priority:2
		* Labels:Uniqueness
		* SourceDB: N/A
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: N/A
		* 2. Run Target Query:SELECT UNQ_ID_IN_SRC_STM, count(*) as frequency FROM INTF.CYC_INTF WHERE UNQ_ID_IN_SRC_STM is not null or UNQ_ID_IN_SRC_STM ='' or UNQ_ID_IN_SRC_STM <=0 GROUP BY UNQ_ID_IN_SRC_STM HAVING count(*)>1
		* Expected Results: Not return any values
		*/
			String targetQuery="SELECT UNQ_ID_IN_SRC_STM, count(*) as frequency FROM INTF.CYC_INTF WHERE UNQ_ID_IN_SRC_STM is not null or UNQ_ID_IN_SRC_STM ='' or UNQ_ID_IN_SRC_STM <=0 GROUP BY UNQ_ID_IN_SRC_STM HAVING count(*)>1";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			Utils.verify(targList,"Not return 0 values");
		}


		@Test(priority=1,groups={"Record Counts","Reconcilation Testing"})
		public void CYC_INTF_14__CLOSED_CYCLE__CYC_INTF_VerifyRecordCounts() throws SQLException {
		/**
		* Test case ID:CYC_INTF_14
		* Test case name:[CLOSED_CYCLE][CYC_INTF]  VerifyRecord Counts
		* Test Description:Verify record counts between source data and target data are same
		* Precondition:
		* Priority:1
		* Labels:Record Counts
		* SourceDB: ORACLE_SIT
		* TargetDB:HIVE_SIT
		* Test details:
		* 1. Run Source Query: SELECT COUNT(*)  AS NUM_RECORDS FROM RATING_OWNER.CLOSED_CYCLE
		* 2. Run Target Query:SELECT COUNT(*) AS NUM_RECORDS FROM INTF.CYC_INTF
		* Expected Results: SQL results between source and target query are same
		*/
			String targetQuery="SELECT COUNT(*) AS NUM_RECORDS FROM INTF.CYC_INTF";
			String sourceQuery="SELECT COUNT(*)  AS NUM_RECORDS FROM RATING_OWNER.CLOSED_CYCLE";
			List<Object> targList=DatabaseUtils.getColumnValues(targetQuery,tagConn);
			List<Object> srcList=DatabaseUtils.getColumnValues(sourceQuery,srcConn);
			List<Object> diffSrcInTarg=Utils.getDiffList(srcList,targList);
			List<Object> diffTargInSrc=Utils.getDiffList(targList,srcList);
			Utils.verify(diffSrcInTarg,"Not found in Source List");
			Utils.verify(diffTargInSrc,"Not found in Target List");
		}
		
}