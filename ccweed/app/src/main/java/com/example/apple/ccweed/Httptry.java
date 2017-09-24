package com.example.apple.ccweed;



import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by mobileheo on 2017-09-23.
 */

public class Httptry extends MapsActivity {


    private Button getBtn;
    private TextView result;
    private OkHttpClient client;
////    Request request = new Request.Builder()
////                            .url("https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood4&key=AIzaSyAGhQI3WPGtrSfvfV06Np79mWj3jow0gwE")
////                            .build();
////
////
////
////    Call call = client.newCall(request);
////    call.enqueue(new Callback(){
////
////    })
////

//    @Override
//    protected void onCreate(Bundle savedInstancesState){
//        Log.d("hello","world");
//        client  = new OkHttpClient();
//        Log.d("myTag", "This is my message");
//        super.onCreate(savedInstancesState);
//        setContentView(R.layout.test);
//        result = (TextView)findViewById(R.id.result);
//        System.out.println("JHH");
//        getBtn = (Button)findViewById(R.id.getBtn);
//        System.out.println("AFTER");
//        getBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                System.console().printf("In onClick fn");
//                System.out.println("in click fn");
//                getWebservice();
//            }
//
//        });
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.location_map);
//        mapFragment.getMapAsync(this);
    }
    public void addone(){
        TextView t = (TextView)findViewById(R.id.result);
        t.setText("q");
    }

    private void getWebservice(){
        System.out.println("in getwebservice fn");
        System.console().printf("In webservice fn");
        final Request request =  new Request.Builder().url("https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood4&key=AIzaSyAGhQI3WPGtrSfvfV06Np79mWj3jow0gwE").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText("Failure");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            System.out.println("Response is: " + response.toString());
                            result.setText(response.body().string());
                        }catch (IOException e){
                            result.setText("error");
                        }
                    }
                });

            }
        });


    }
//    private void getWebservice(){
//        final Request request = new Request.Builder().url("https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood4&key=AIzaSyAGhQI3WPGtrSfvfV06Np79mWj3jow0gwE").build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//                public void onFailure(Call call, IOException e) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            result.setText("Failure!");
//                        }
//                    });
//                }
//
//            @Override
//            public void onResponse(Call call, final Response response) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            // try{
//                            System.out.println(response.toString());
//                            result.setText(response.toString());
//                            //}catch (IOException ioe){
//                            //  result.setText("Error!");
//                            //}
//                        }
//                    });
//            }
//        }
//
//        });
//
//    }


//    @Override
//    protected Object onCreate(Bundle savedInstancesState) {
//        super.onCreate(savedInstancesState);
//        setContentView(R.layout.activity_main);
//
//        new
//    }


    /*
 @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.test);





                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://webdxd-student-api.herokuapp.com/student")
                        .build();

                try{
                    Response response = client.newCall(request).execute();
                    Log.d("lala",response.body().string());

                }catch (IOException e){
                    e.printStackTrace();
                }



    }
    */

//    private double getDistanceInfo(double lat1, double lng1, String destinationAddress) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Double dist = 0.0;
//        try {
//
//            destinationAddress = destinationAddress.replaceAll(" ","%20");
//            String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + latFrom + "," + lngFrom + "&destination=" + latTo + "," + lngTo + "&mode=driving&sensor=false";
//
//            HttpPost httppost = new HttpPost(url);
//
//            HttpClient client = new DefaultHttpClient();
//            HttpResponse response;
//            stringBuilder = new StringBuilder();
//
//
//            response = client.execute(httppost);
//            HttpEntity entity = response.getEntity();
//            InputStream stream = entity.getContent();
//            int b;
//            while ((b = stream.read()) != -1) {
//                stringBuilder.append((char) b);
//            }
//        } catch (ClientProtocolException e) {
//        } catch (IOException e) {
//        }
//
//        JSONObject jsonObject = new JSONObject();
//        try {
//
//            jsonObject = new JSONObject(stringBuilder.toString());
//
//            JSONArray array = jsonObject.getJSONArray("routes");
//
//            JSONObject routes = array.getJSONObject(0);
//
//            JSONArray legs = routes.getJSONArray("legs");
//
//            JSONObject steps = legs.getJSONObject(0);
//
//            JSONObject distance = steps.getJSONObject("distance");
//
//            Log.i("Distance", distance.toString());
//            dist = Double.parseDouble(distance.getString("text").replaceAll("[^\\.0123456789]","") );
//
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return dist;
//    }




/*
    public String[] getDirectionData(String srcPlace, String destPlace) {

        String urlString = "http://maps.google.com/maps?f=d&hl=en&saddr="
                + srcPlace + "&daddr=" + destPlace
                + "&ie=UTF8&0&om=0&output=kml";
        Log.d("URL", urlString);
        Document doc = null;
        HttpURLConnection urlConnection = null;
        URL url = null;
        String pathConent = "";
        try {

            url = new URL(urlString.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.connect();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(urlConnection.getInputStream());

        } catch (Exception e) {
        }

        NodeList nl = doc.getElementsByTagName("LineString");
        for (int s = 0; s < nl.getLength(); s++) {
            Node rootNode = nl.item(s);
            NodeList configItems = rootNode.getChildNodes();
            for (int x = 0; x < configItems.getLength(); x++) {
                Node lineStringNode = configItems.item(x);
                NodeList path = lineStringNode.getChildNodes();
                pathConent = path.item(0).getNodeValue();
            }
        }
        String[] tempContent = pathConent.split(" ");
        return tempContent;
    }

    protected void onCreate(Bundle savedInstancesState){
        //client  = new OkHttpClient();
        Log.d("myTag", "This is my message");
        super.onCreate(savedInstancesState);
        setContentView(test);
        result = (TextView)findViewById(R.id.result);
        getBtn = (Button)findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener(){
            String start = "Disneyland";
            String destination = "Universal+Studios+Hollywood4";
            String output = getDirectionData(start, destination)[0];

            public void onClick(View view){
                result.setText(output);
            }

        });

    }*/
//    public void showtext(View view){
////        if(view.getId() == getBtn){
////            result.setText("1");
////        }
//
//        System.out.println("hello");
//
//    }
//

}
