package com.myjava.test;

//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.scheme.SchemeSocketFactory;
//import org.apache.http.impl.client.DefaultHttpClient;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;

//public class SSLClient extends DefaultHttpClient {
//
//    public SSLClient() throws Exception{
//        super();
//        SSLContext ctx = SSLContext.getInstance("TLS");
//        X509TrustManager tm = new X509TrustManager() {
//            @Override
//            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//
//            }
//
//            @Override
//            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//
//            }
//
//            @Override
//            public X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//        };
//
//        ctx.init(null, new TrustManager[]{tm}, null);
//        SSLSocketFactory ssf = new SSLSocketFactory() {
//            @Override
//            public String[] getDefaultCipherSuites() {
//                return new String[0];
//            }
//
//            @Override
//            public String[] getSupportedCipherSuites() {
//                return new String[0];
//            }
//
//            @Override
//            public Socket createSocket(Socket socket, String s, int i, boolean b) throws IOException {
//                return null;
//            }
//
//            @Override
//            public Socket createSocket(String s, int i) throws IOException, UnknownHostException {
//                return null;
//            }
//
//            @Override
//            public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException, UnknownHostException {
//                return null;
//            }
//
//            @Override
//            public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
//                return null;
//            }
//
//            @Override
//            public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
//                return null;
//            }
//        };
//
//
//        ClientConnectionManager ccm =  this.getConnectionManager();
//        SchemeRegistry registry = ccm.getSchemeRegistry();
//        registry.register(new Scheme("https", 443, (SchemeSocketFactory) ssf));
//    }
//}
