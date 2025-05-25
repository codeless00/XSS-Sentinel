package burp;

import java.util.List;
import java.net.MalformedURLException;
import java.net.URL;


public class ExtensionHelpers {
    IExtensionHelpers helpers;
    IBurpExtenderCallbacks callbacks;
    // PrintWriter out;


    ExtensionHelpers(IBurpExtenderCallbacks callbacks){
        this.helpers = callbacks.getHelpers();
        this.callbacks = callbacks;
        // this.out = new PrintWriter(callbacks.getStdout());

        // url_encode("iwanna/shine/=$&{';.<./\\^54@`!=-'}");
        // List<String> headers = List.of("POST /path/file.txt HTTP/1.1", "Host: www.google.com");
        // build_http_message(headers, null);
        // try {
        //     build_http_request(new URL("https://www.facebook.com"));
        // } catch (MalformedURLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // new HttpListener(callbacks,this);  // Calls analyse_request and analyse_response
  
    }


    void url_encode(String data){

        String encoded_data = helpers.urlEncode(data);
        callbacks.printOutput("Before Encoding: ");
        callbacks.printOutput(data);
        callbacks.printOutput("After Encoding: ");
        callbacks.printOutput(encoded_data);
    }

    void analyse_request(IHttpRequestResponse reqres) {
        IRequestInfo requestInfo = helpers.analyzeRequest(reqres);
        List<String> headers = requestInfo.getHeaders();
        callbacks.printOutput("Analysing Request: ");
        callbacks.printOutput("Method: " + requestInfo.getMethod());
        callbacks.printOutput("URL: " + requestInfo.getUrl().toString());
        callbacks.printOutput("Headers: ");
        for (String header : headers) {
            callbacks.printOutput(header);
        }

    }

    void analyse_request(IHttpService httpService, byte[] request){

        IRequestInfo requestInfo = helpers.analyzeRequest(httpService,request);
        List<String> headers = requestInfo.getHeaders();
        callbacks.printOutput("Analysing Reques: ");
        callbacks.printOutput("Method: " + requestInfo.getMethod());
        callbacks.printOutput("URL: " + requestInfo.getUrl().toString());
        callbacks.printOutput("Headers: ");
        for (String header : headers) {
            callbacks.printOutput(header);
        } 

    }


    // It will only show request method because if service is not available
    // It's catchy sometimes try not to use this
    void analyse_request(byte[] request){
        callbacks.printOutput("Request: ");
        String message = new String(request);
        callbacks.printOutput(message);
        callbacks.printOutput("\n");
    }



    void analyse_response(IHttpRequestResponse reqres){
        IResponseInfo responseInfo = helpers.analyzeResponse(reqres.getResponse());
        List<String> headers = responseInfo.getHeaders();
        callbacks.printOutput("Analysing Response: ");
        callbacks.printOutput("StatusCode: " + String.valueOf(responseInfo.getStatusCode()));
        callbacks.printOutput("Headers: ");
        for (String header : headers) {
            callbacks.printOutput(header);
        }
        
    }

    void analyse_response(byte[] response){
        callbacks.printOutput("Response: ");
        String message = new String(response);
        callbacks.printOutput(message);
        callbacks.printOutput("\n");

    } 

    void build_http_message(List<String> headers, byte[] body){
        byte[] message = helpers.buildHttpMessage(headers, body);
        IHttpService service = helpers.buildHttpService("www.google.com", 443, true);
        analyse_request(service, message);
    }

    void build_http_request(URL url){
        byte[] message = helpers.buildHttpRequest(url);
        // analyse_request(message);


    }



}
