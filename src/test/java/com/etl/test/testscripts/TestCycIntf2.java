package com.etl.test.testscripts;
import org.testng.annotations.Test;
import com.etl.common.database.DatabaseUtils;
import java.util.List;
import com.etl.test.testconfig.TestConfig;
import java.sql.SQLException;
import com.etl.common.Utils;


public class TestCycIntf2 extends TestConfig {


		@Test(priority=1,groups={"Metadata","Target Validation Testing"})
		public void CYCINTF_01__CYC_INTF_VerifyTargetSchematable() throws SQLException {
		/**
		* Test case ID:CYCINTF_01
		* Test case name:[CYC_INTF] Verify Target Schema table
		* Test Description:Check target schema table and data type columns target
		* Precondition:
		* Priority:1
		* Labels:Metadata
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select table_name,column_name,data_type, * From information_schema.columns a where table_name = 'CYC_INTF_DES'
		* 2. Run Target Query:Select table_name,column_name,data_type From information_schema.columns a where table_name = 'CYC_INTF'
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select table_name,column_name,data_type, * From information_schema.columns a where table_name = 'CYC_INTF_DES'";
			String targetQuery="Select table_name,column_name,data_type From information_schema.columns a where table_name = 'CYC_INTF'";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Record Counts","Reconcilation Testing"})
		public void CYCINTF_02__CYC_INTF_CheckRecordCounts() throws SQLException {
		/**
		* Test case ID:CYCINTF_02
		* Test case name:[CYC_INTF] Check Record Counts
		* Test Description:filter condition source table: No filter
		* Precondition:
		* Priority:1
		* Labels:Record Counts
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select count(*) from CLOSED_CYCLE
		* 2. Run Target Query:select count(*) from "CYC_INTF"
		* Expected Results: equal number of source and destination tables
		*/
			String sourceQuery="select count(*) from CLOSED_CYCLE";
			String targetQuery="select count(*) from \"CYC_INTF\"";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_03__CYC_INTF__UNQ_ID_IN_SRC_STM_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_03
		* Test case name:[CYC_INTF][UNQ_ID_IN_SRC_STM] Check Validate Values
		* Test Description:Mapping rule by: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_04__CYC_INTF__CYC_CODE_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_04
		* Test case name:[CYC_INTF][CYC_CODE] Check Validate Values
		* Test Description:Mapping rule by: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,CYCLE_CODE From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,CYC_CODE From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,CYCLE_CODE From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,CYC_CODE From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_05__CYC_INTF__CYC_NM_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_05
		* Test case name:[CYC_INTF][CYC_NM] Check Validate Values
		* Test Description:Mapping rule by: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,CYCLE_NAME From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,CYC_NM From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,CYCLE_NAME From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,CYC_NM From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_06__CYC_INTF__CYC_STT_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_06
		* Test case name:[CYC_INTF][CYC_STT] Check Validate Values
		* Test Description:Mapping rule by: DIRECT
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,STATUS From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,CYC_STT From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,STATUS From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,CYC_STT From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_07__CYC_INTF__SRC_STM_CODE_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_07
		* Test case name:[CYC_INTF][SRC_STM_CODE] Check Validate Values
		* Test Description:Mapping rule by: FIX value 'TEAM'
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,TEAM' From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,SRC_STM_CODE From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,TEAM' From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,SRC_STM_CODE From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_08__CYC_INTF__SRC_STM_NM_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_08
		* Test case name:[CYC_INTF][SRC_STM_NM] Check Validate Values
		* Test Description:Mapping rule by: FIX value 'CALL TEAM'
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,CALL TEAM' From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,SRC_STM_NM From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,CALL TEAM' From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,SRC_STM_NM From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_09__CYC_INTF__PCS_DT_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_09
		* Test case name:[CYC_INTF][PCS_DT] Check Validate Values
		* Test Description:Mapping rule by: FIX value ETL_DATE
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,:ETL_DATE From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,PCS_DT From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,:ETL_DATE From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,PCS_DT From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_10__CYC_INTF__CRN_ROW_IND_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_10
		* Test case name:[CYC_INTF][CRN_ROW_IND] Check Validate Values
		* Test Description:Mapping rule by: FIX value 1
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,1 From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,CRN_ROW_IND From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,1 From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,CRN_ROW_IND From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_11__CYC_INTF__EFF_FM_TMS_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_11
		* Test case name:[CYC_INTF][EFF_FM_TMS] Check Validate Values
		* Test Description:Mapping rule by: FIX value SYS_DATE
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,SYS_DATE From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,EFF_FM_TMS From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,SYS_DATE From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,EFF_FM_TMS From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_12__CYC_INTF__EFF_TO_TMS_CheckValidateValues() throws SQLException {
		/**
		* Test case ID:CYCINTF_12
		* Test case name:[CYC_INTF][EFF_TO_TMS] Check Validate Values
		* Test Description:Mapping rule by: FIX value '2400-01-01 23:59:59'
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: Select CYCLE_ID,1/1/2400  11:59:59 PM From CLOSED_CYCLE
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM,EFF_TO_TMS From CYC_INTF
		* Expected Results: Number of returned reccord =0
		*/
			String sourceQuery="Select CYCLE_ID,1/1/2400  11:59:59 PM From CLOSED_CYCLE";
			String targetQuery="Select UNQ_ID_IN_SRC_STM,EFF_TO_TMS From CYC_INTF";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Uniqueness","Target Validation Testing"})
		public void CYCINTF_13__CYC_INTF___CheckUniqueness() throws SQLException {
		/**
		* Test case ID:CYCINTF_13
		* Test case name:[CYC_INTF][] Check Uniqueness
		* Test Description:Field UNQ_ID_IN_SRC_STM ||'-'|| EFF_FM_TMS data is uniqueness
		* Precondition:
		* Priority:2
		* Labels:Uniqueness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM,EFF_FM_TMS, count(*) from "CYC_INTF" group by UNQ_ID_IN_SRC_STM, EFF_FM_TMS Having count(*) > 1
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select UNQ_ID_IN_SRC_STM,EFF_FM_TMS, count(*) from \"CYC_INTF\" group by UNQ_ID_IN_SRC_STM, EFF_FM_TMS Having count(*) > 1";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Uniqueness","Target Validation Testing"})
		public void CYCINTF_14__CYC_INTF__CYC_ANCHOR_ID_CheckUniqueness() throws SQLException {
		/**
		* Test case ID:CYCINTF_14
		* Test case name:[CYC_INTF][CYC_ANCHOR_ID] Check Uniqueness
		* Test Description:Field CYC_ANCHOR_ID data is uniqueness
		* Precondition:
		* Priority:2
		* Labels:Uniqueness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select CYC_ANCHOR_ID, count(*) from "CYC_INTF" group by CYC_ANCHOR_ID Having count(*) > 1
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select CYC_ANCHOR_ID, count(*) from \"CYC_INTF\" group by CYC_ANCHOR_ID Having count(*) > 1";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_15__CYC_INTF__UNQ_ID_IN_SRC_STM_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_15
		* Test case name:[CYC_INTF][UNQ_ID_IN_SRC_STM] Check Completeness
		* Test Description:Field UNQ_ID_IN_SRC_STM data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where UNQ_ID_IN_SRC_STM is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where UNQ_ID_IN_SRC_STM is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_16__CYC_INTF__PCS_DT_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_16
		* Test case name:[CYC_INTF][PCS_DT] Check Completeness
		* Test Description:Field PCS_DT data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where PCS_DT is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where PCS_DT is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_17__CYC_INTF__PPN_TMS_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_17
		* Test case name:[CYC_INTF][PPN_TMS] Check Completeness
		* Test Description:Field PPN_TMS data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where PPN_TMS is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where PPN_TMS is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_18__CYC_INTF__SRC_STM_CODE_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_18
		* Test case name:[CYC_INTF][SRC_STM_CODE] Check Completeness
		* Test Description:Field SRC_STM_CODE data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where SRC_STM_CODE is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where SRC_STM_CODE is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_19__CYC_INTF__SRC_STM_NM_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_19
		* Test case name:[CYC_INTF][SRC_STM_NM] Check Completeness
		* Test Description:Field SRC_STM_NM data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where SRC_STM_NM is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where SRC_STM_NM is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_20__CYC_INTF__CYC_ANCHOR_ID_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_20
		* Test case name:[CYC_INTF][CYC_ANCHOR_ID] Check Completeness
		* Test Description:Field SRC_STM_NM data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where CYC_ANCHOR_ID is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where CYC_ANCHOR_ID is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_21__CYC_INTF__CRN_ROW_IND_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_21
		* Test case name:[CYC_INTF][CRN_ROW_IND] Check Completeness
		* Test Description:Field SRC_STM_NM data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where CRN_ROW_IND is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where CRN_ROW_IND is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_22__CYC_INTF__EFF_FM_TMS_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_22
		* Test case name:[CYC_INTF][EFF_FM_TMS] Check Completeness
		* Test Description:Field SRC_STM_NM data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where EFF_FM_TMS is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where EFF_FM_TMS is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Completeness","Target Validation Testing"})
		public void CYCINTF_23__CYC_INTF__EFF_TO_TMS_CheckCompleteness() throws SQLException {
		/**
		* Test case ID:CYCINTF_23
		* Test case name:[CYC_INTF][EFF_TO_TMS] Check Completeness
		* Test Description:Field SRC_STM_NM data is not null
		* Precondition:
		* Priority:2
		* Labels:Completeness
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where EFF_TO_TMS is null
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where EFF_TO_TMS is null";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_24__CYC_INTF__SRC_STM_CODE_CheckValidity() throws SQLException {
		/**
		* Test case ID:CYCINTF_24
		* Test case name:[CYC_INTF][SRC_STM_CODE] Check Validity
		* Test Description:Field SRC_STM_CODE  
only 1 value is 'CYCLE'
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where SRC_STM_CODE <> 'CYCLE'
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where SRC_STM_CODE <> 'CYCLE'";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_25__CYC_INTF__SRC_STM_NM_CheckValidity() throws SQLException {
		/**
		* Test case ID:CYCINTF_25
		* Test case name:[CYC_INTF][SRC_STM_NM] Check Validity
		* Test Description:Field SRC_STM_NM  
only 1 value is 'CLOSED_CYCLE'
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where SRC_STM_NM <> 'CLOSED_CYCLE'
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where SRC_STM_NM <> 'CLOSED_CYCLE'";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_26__CYC_INTF__CRN_ROW_IND_CheckValidity() throws SQLException {
		/**
		* Test case ID:CYCINTF_26
		* Test case name:[CYC_INTF][CRN_ROW_IND] Check Validity
		* Test Description:Field CRN_ROW_IND in (0,1)
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from CYC_INTF where CRN_ROW_IND NOT IN (0,1)
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from CYC_INTF where CRN_ROW_IND NOT IN (0,1)";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_27__CYC_INTF___CheckValidity() throws SQLException {
		/**
		* Test case ID:CYCINTF_27
		* Test case name:[CYC_INTF][] Check Validity
		* Test Description:For records with EFF_TO_TMS = '2400-01-01 23:59:59', field CRN_ROW_IND must be equal to 1
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:SELECT COUNT(*) FROM "CYC_INTF" WHERE EFF_TO_TMS = '2400-01-01 23:59:59' AND CRN_ROW_IND <> 1
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="SELECT COUNT(*) FROM \"CYC_INTF\" WHERE EFF_TO_TMS = '2400-01-01 23:59:59' AND CRN_ROW_IND <> 1";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_28__CYC_INTF___Checkvalue() throws SQLException {
		/**
		* Test case ID:CYCINTF_28
		* Test case name:[CYC_INTF][] Check value
		* Test Description:EFF_TO_TMS of previous record = EFF_FM_TMS of following record
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:WITH "CYC_INTF" AS ( SELECT ROW_NUMBER () OVER (PARTITION BY UNQ_ID_IN_SRC_STM ORDER BY EFF_FM_TMS ASC) AS RANK 	, UNQ_ID_IN_SRC_STM 	, EFF_FM_TMS 	, EFF_TO_TMS FROM "CYC_INTF" ) SELECT a.UNQ_ID_IN_SRC_STM, a.EFF_FM_TMS, a.EFF_TO_TMS, b.EFF_FM_TMS, b.EFF_TO_TMS FROM "CYC_INTF" a  JOIN "CYC_INTF" b ON a.UNQ_ID_IN_SRC_STM = b.UNQ_ID_IN_SRC_STM AND a.RANK = b.RANK + 1 WHERE a.EFF_FM_TMS <> b.EFF_TO_TMS
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="WITH \"CYC_INTF\" AS ( SELECT ROW_NUMBER () OVER (PARTITION BY UNQ_ID_IN_SRC_STM ORDER BY EFF_FM_TMS ASC) AS RANK 	, UNQ_ID_IN_SRC_STM 	, EFF_FM_TMS 	, EFF_TO_TMS FROM \"CYC_INTF\" ) SELECT a.UNQ_ID_IN_SRC_STM, a.EFF_FM_TMS, a.EFF_TO_TMS, b.EFF_FM_TMS, b.EFF_TO_TMS FROM \"CYC_INTF\" a  JOIN \"CYC_INTF\" b ON a.UNQ_ID_IN_SRC_STM = b.UNQ_ID_IN_SRC_STM AND a.RANK = b.RANK + 1 WHERE a.EFF_FM_TMS <> b.EFF_TO_TMS";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_29__CYC_INTF___Checkvalidity() throws SQLException {
		/**
		* Test case ID:CYCINTF_29
		* Test case name:[CYC_INTF][] Check validity
		* Test Description:At 1 record: EFF_FM_TMS>= EFF_TO_TMS
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:SELECT count(*) FROM "CYC_INTF" WHERE EFF_FM_TMS > EFF_TO_TMS
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="SELECT count(*) FROM \"CYC_INTF\" WHERE EFF_FM_TMS > EFF_TO_TMS";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_30__CYC_INTF__PCS_DT_Checkvalue() throws SQLException {
		/**
		* Test case ID:CYCINTF_30
		* Test case name:[CYC_INTF] [PCS_DT ] Check value
		* Test Description:Field PCS_DT is less than or equal to current date
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from "CYC_INTF" where PCS_DT <= @Sysdate
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from \"CYC_INTF\" where PCS_DT <= @Sysdate";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validity","Target Validation Testing"})
		public void CYCINTF_31__CYC_INTF__PCS_DT_Checkformat() throws SQLException {
		/**
		* Test case ID:CYCINTF_31
		* Test case name:[CYC_INTF] [PCS_DT ] Check format
		* Test Description:Field PCS_DT is like format YYYY-MM-DD
		* Precondition:
		* Priority:2
		* Labels:Validity
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:select count(*) from "CYC_INTF"  where "PCS_DT" !~* '([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))'
		* Expected Results: Return number is 0
		*/
			String sourceQuery="";
			String targetQuery="select count(*) from \"CYC_INTF\"  where \"PCS_DT\" !~* '([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))'";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_32__CYC_INTF__CYC_CODE_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_32
		* Test case name:[CYC_INTF][CYC_CODE] Update record data
		* Test Description:Update data record, field CYC_CODE
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CYC_CODE From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields CYC_CODE
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CYC_CODE From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_33__CYC_INTF__CYC_NM_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_33
		* Test case name:[CYC_INTF][CYC_NM] Update record data
		* Test Description:Update data record, field CYC_NM
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CYC_NM From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields CYC_NM
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CYC_NM From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_34__CYC_INTF__CYC_STT_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_34
		* Test case name:[CYC_INTF][CYC_STT] Update record data
		* Test Description:Update data record, field CYC_STT
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CYC_STT From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields CYC_STT
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CYC_STT From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_35__CYC_INTF__PCS_DT_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_35
		* Test case name:[CYC_INTF][PCS_DT] Update record data
		* Test Description:Update data record, field PCS_DT
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, PCS_DT From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields PCS_DT
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, PCS_DT From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_36__CYC_INTF__CRN_ROW_IND_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_36
		* Test case name:[CYC_INTF][CRN_ROW_IND] Update record data
		* Test Description:Update data record, field CRN_ROW_IND
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, CRN_ROW_IND From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields CRN_ROW_IND
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, CRN_ROW_IND From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_37__CYC_INTF__EFF_FM_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_37
		* Test case name:[CYC_INTF][EFF_FM_TMS] Update record data
		* Test Description:Update data record, field EFF_FM_TMS
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, EFF_FM_TMS From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields EFF_FM_TMS
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, EFF_FM_TMS From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_38__CYC_INTF__EFF_TO_TMS_Updaterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_38
		* Test case name:[CYC_INTF][EFF_TO_TMS] Update record data
		* Test Description:Update data record, field EFF_TO_TMS
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select UNQ_ID_IN_SRC_STM, EFF_TO_TMS From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Newly updated data of fields EFF_TO_TMS
		*/
			String sourceQuery="";
			String targetQuery="Select UNQ_ID_IN_SRC_STM, EFF_TO_TMS From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_39__CYC_INTF_Deleterecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_39
		* Test case name:["CYC_INTF"] Delete record data
		* Test Description:Delete record data
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: 
		* 2. Run Target Query:Select * From CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: 
Update fields: CYC_CODE, CYC_NM, CYC_STT to null
		*/
			String sourceQuery="";
			String targetQuery="Select * From CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_40__CYC_INTF__UNQ_ID_IN_SRC_STM_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_40
		* Test case name:[CYC_INTF] [UNQ_ID_IN_SRC_STM] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM from CYC_INTF where UNQ_ID_IN_SRC_STM = ''
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM from CYC_INTF where UNQ_ID_IN_SRC_STM = ''";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=2,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_41__CYC_INTF__CYC_CODE_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_41
		* Test case name:[CYC_INTF] [CYC_CODE] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:2
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, CYCLE_CODE from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, CYC_CODE from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, CYCLE_CODE from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, CYC_CODE from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_42__CYC_INTF__CYC_NM_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_42
		* Test case name:[CYC_INTF] [CYC_NM] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, CYCLE_NAME from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, CYC_NM from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, CYCLE_NAME from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, CYC_NM from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_43__CYC_INTF__CYC_STT_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_43
		* Test case name:[CYC_INTF] [CYC_STT] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, STATUS from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, CYC_STT from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, STATUS from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, CYC_STT from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_44__CYC_INTF__SRC_STM_CODE_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_44
		* Test case name:[CYC_INTF] [SRC_STM_CODE] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, 'CYCLE' as SRC_STM_CODE from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, SRC_STM_CODE from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, 'CYCLE' as SRC_STM_CODE from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, SRC_STM_CODE from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_45__CYC_INTF__SRC_STM_NM_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_45
		* Test case name:[CYC_INTF] [SRC_STM_NM] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, 'CLOSED_CYCLE' as SRC_STM_NM from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, SRC_STM_NM from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, 'CLOSED_CYCLE' as SRC_STM_NM from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, SRC_STM_NM from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_46__CYC_INTF__PCS_DT_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_46
		* Test case name:[CYC_INTF] [PCS_DT] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, 'ETL_DATE' as PCS_DT from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, PCS_DT from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, 'ETL_DATE' as PCS_DT from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, PCS_DT from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_47__CYC_INTF__CRN_ROW_IND_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_47
		* Test case name:[CYC_INTF] [CRN_ROW_IND] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, '1' as CRN_ROW_IND from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, CRN_ROW_IND from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, '1' as CRN_ROW_IND from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, CRN_ROW_IND from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_48__CYC_INTF__EFF_FM_TMS_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_48
		* Test case name:[CYC_INTF] [EFF_FM_TMS] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, 'SYS_DATE' as EFF_FM_TMS from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, EFF_FM_TMS from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, 'SYS_DATE' as EFF_FM_TMS from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, EFF_FM_TMS from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}


		@Test(priority=1,groups={"Validate Values","Reconcilation Testing"})
		public void CYCINTF_49__CYC_INTF__EFF_TO_TMS_Addnewrecorddata() throws SQLException {
		/**
		* Test case ID:CYCINTF_49
		* Test case name:[CYC_INTF] [EFF_TO_TMS] Add new record data
		* Test Description:Add new data record
		* Precondition:
		* Priority:1
		* Labels:Validate Values
		* SourceDB: RATING_OWNER
		* TargetDB:RATING_OWNER
		* Test details:
		* 1. Run Source Query: select CYCLE_ID, '1/1/2400  11:59:59 PM' as EFF_TO_TMS from CLOSED_CYCLE where CYCLE_ID = '' 
		* 2. Run Target Query:select UNQ_ID_IN_SRC_STM, EFF_TO_TMS from CYC_INTF where UNQ_ID_IN_SRC_STM = 
		* Expected Results: Return number is 0
		*/
			String sourceQuery="select CYCLE_ID, '1/1/2400  11:59:59 PM' as EFF_TO_TMS from CLOSED_CYCLE where CYCLE_ID = '' ";
			String targetQuery="select UNQ_ID_IN_SRC_STM, EFF_TO_TMS from CYC_INTF where UNQ_ID_IN_SRC_STM = ";
			List<Object> diffResultQueries=DatabaseUtils.getDiffResultQueries(sourceQuery,targetQuery,srcConn,tagConn);
			Utils.verify(diffResultQueries);
		}
		
}