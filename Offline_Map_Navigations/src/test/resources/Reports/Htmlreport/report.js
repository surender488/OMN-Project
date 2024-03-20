$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/DownloadOfflineBundle.feature");
formatter.feature({
  "name": "To Valited the download offline bundle functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To verify the download offline bundle Offline bundle",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@offlnebundles"
    }
  ]
});
formatter.step({
  "name": "User check all offline download bundles",
  "keyword": "Given "
});
formatter.match({
  "location": "DownloadOfflineBundle.user_check_all_offline_download_bundles()"
});
formatter.result({
  "status": "passed"
});
});