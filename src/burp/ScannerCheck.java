package burp;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class ScannerCheck implements IScannerCheck {

    IBurpExtenderCallbacks callbacks;
    BurpExtender extender;

    public ScannerCheck(IBurpExtenderCallbacks callbacks, BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<IScanIssue> doPassiveScan(IHttpRequestResponse baseRequestResponse) {

        List<IScanIssue> issues = new ArrayList<>();

        IScanIssue issue1 = new IScanIssue() {

            @Override
            public URL getUrl() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getUrl'");
            }

            @Override
            public String getIssueName() {
                // TODO Auto-generated method stub
                return "Custom issue";
                // throw new UnsupportedOperationException("Unimplemented method 'getIssueName'");
            }

            @Override
            public int getIssueType() {
                // TODO Auto-generated method stub
                return 3;
            }

            @Override
            public String getSeverity() {
                // TODO Auto-generated method stub
                return "custom-severity";
            }

            @Override
            public String getConfidence() {
                // TODO Auto-generated method stub
                return "custom-confidence";
            }

            @Override
            public String getIssueBackground() {
                // TODO Auto-generated method stub
                return "custom-issue--background";
            }

            @Override
            public String getRemediationBackground() {
                // TODO Auto-generated method stub
                return "custom-remediation--background";
            }

            @Override
            public String getIssueDetail() {
                // TODO Auto-generated method stub
                return "custom-issue-details";
            }

            @Override
            public String getRemediationDetail() {
                // TODO Auto-generated method stub
                return "custom-remediation-details";
            }

            @Override
            public IHttpRequestResponse[] getHttpMessages() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public IHttpService getHttpService() {
                // TODO Auto-generated method stub
                IHttpService service = new IHttpService() {

                    @Override
                    public String getHost() {
                        // TODO Auto-generated method stub
                        return "custom-host.com";
                    }

                    @Override
                    public int getPort() {
                        // TODO Auto-generated method stub
                        return 443;
                    }

                    @Override
                    public String getProtocol() {
                        // TODO Auto-generated method stub
                        return "https";
                    }
                    
                };

                return service;
            }
            ;
        };

        issues.add(issue1);
        return issues;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'doPassiveScan'");
    }

    @Override
    public List<IScanIssue> doActiveScan(IHttpRequestResponse baseRequestResponse,
            IScannerInsertionPoint insertionPoint) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doActiveScan'");
    }

    @Override
    public int consolidateDuplicateIssues(IScanIssue existingIssue, IScanIssue newIssue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consolidateDuplicateIssues'");
    }
    
}
