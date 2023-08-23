package api_utils;

public class FE_URL_paths {
	
	public static String main_url=FE_route.main_url;				//"https://44.197.194.76:8080/dbconsole";
	
	
//	-----------------------------------------DO NOT EDIT----------------------------------------------------

	public static String post_url_login=main_url+"/login";

	public static String post_url_cr_conn=main_url+"/createConnection";
	
	public static String post_url_cr_template=main_url+"/createDataTemplate";
	
	public static String post_url_cr_validation=main_url+"/createValidationCheck";

	public static String post_url_run_task=main_url+"/runTaskResult";
	
	public static String post_url_get_results_null=main_url+"/getDQNullCheckResults";
	
	public static String post_url_get_results_dup=main_url+"/getDQDuplicateCheckSummaryResults";
	
	public static String post_url_get_results_date=main_url+"/getDQDateConsistencyResults";

	public static String post_url_get_results_VA=main_url+"/getDQRecordAnomalyResults";
	
	public static String post_url_get_results_dis=main_url+"/getDQDistributionCheckResults";
	
	public static String post_url_get_results_bad=main_url+"/getDQBadDataCheckResults";
	
	public static String post_url_get_results_def_chk=main_url+"/getDQDefaultValueCheckResults";

	public static String post_url_get_results_length=main_url+"/getDQLengthCheckResults";
	
	public static String post_url_get_results_reg_pattern=main_url+"/getDQUserDefinedRegexPResults";
	
	public static String post_url_get_results_def_pattern=main_url+"/getDQAutoDiscoverRegexPResults";
	
	public static String post_url_get_results_data_drift=main_url+"/getDQDataDriftResults";
	
	public static String post_url_activate_check=main_url+"/activateColumnCheckInTemplate";
	
	public static String post_url_approve_status=main_url+"/rc/saveRuleCatalogStatus";

	public static String post_url_search_validation=main_url+"/validationslists";
	
	public static String post_url_activate_check_his=main_url+"/customizeUpdateValidation";
	
	public static String post_url_view_template=main_url+"/dataTemplateView";
	
	public static String post_url_edit_template_chk=main_url+"/editCheck";
	
	public static String post_url_approve_template=main_url+"/updateTemplateDeltaApprovalStatus";
	
	public static String post_url_app_col=main_url+"/approveColumnAnalysisChanges";

}
