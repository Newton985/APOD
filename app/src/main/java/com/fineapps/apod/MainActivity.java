package com.fineapps.apod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    final String API_KEY="";
    String active = "one";
    private RecyclerView commentsView;
    /* access modifiers changed from: private */
    public TextView date1;
    /* access modifiers changed from: private */
    public TextView date2;
    /* access modifiers changed from: private */
    public TextView date3;
    /* access modifiers changed from: private */
    public TextView date4;
    /* access modifiers changed from: private */
    public TextView date5;
    private String datea;
    private String dateb;
    private String datec;
    private String dated;
    private String datee;
    List<String> day1details = new ArrayList();
    List<String> day2details = new ArrayList();
    List<String> day3details = new ArrayList();
    List<String> day4details = new ArrayList();
    List<String> day5details = new ArrayList();
    private TextView description;
    private AppCompatButton download;
    /* access modifiers changed from: private */
    public CircleImageView image1;
    /* access modifiers changed from: private */
    public CircleImageView image2;
    /* access modifiers changed from: private */
    public CircleImageView image3;
    /* access modifiers changed from: private */
    public CircleImageView image4;
    /* access modifiers changed from: private */
    public CircleImageView image5;
    private ImageView pod;
    /* access modifiers changed from: private */
    private AppCompatButton setwall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container1=findViewById(R.id.container1);
        this.image1 = (CircleImageView) findViewById(R.id.profile_image2);
        this.image2 = (CircleImageView) findViewById(R.id.profile_image3);
        this.image3 = (CircleImageView) findViewById(R.id.profile_image4);
        this.image4 = (CircleImageView) findViewById(R.id.profile_image5);
        this.image5 = (CircleImageView) findViewById(R.id.profile_image);
        this.date1 = (TextView) findViewById(R.id.date2);
        this.date2 = (TextView) findViewById(R.id.date3);
        this.date3 = (TextView) findViewById(R.id.date4);
        this.date4 = (TextView) findViewById(R.id.date5);
        this.date5 = (TextView) findViewById(R.id.date);
        this.pod = (ImageView) findViewById(R.id.pod);
        this.description = (TextView) findViewById(R.id.description);
        this.setwall = (AppCompatButton) findViewById(R.id.setwallbt);
        this.download = (AppCompatButton) findViewById(R.id.downloadbt);
        this.datea = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date dat = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dat);
        calendar.add(5, -1);
        this.dateb = dateFormat.format(calendar.getTime());
        calendar.add(5, -1);
        this.datec = dateFormat.format(calendar.getTime());
        calendar.add(5, -1);
        this.dated = dateFormat.format(calendar.getTime());
        calendar.add(5, -1);
        this.datee = dateFormat.format(calendar.getTime());







        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest date1request = new JsonObjectRequest(0, "https://api.nasa.gov/planetary/apod?api_key=IkBHUM74New6dImwPRdaJsDEBHBhFczejiuyw9aK", (JSONObject) null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try {
                    day1details.add("fgfg");
                    day1details.add(response.getString("date"));
                    day1details.add(response.getString("explanation"));
                    day1details.add(response.getString("title"));
                    day1details.add(response.getString("url"));
                   // Glide.with(getApplicationContext()).load(day1details.get(4)).apply(RequestOptions.circleCropTransform()).apply(RequestOptions.centerCropTransform()).into((ImageView) image1);
                   GlideApp.with(getApplicationContext()).load(response.getString("url")).centerCrop().into((ImageView)image1);
                    date1.setText(response.getString("date"));
                    showDate1();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        });

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(0, "https://api.nasa.gov/planetary/apod?api_key=IkBHUM74New6dImwPRdaJsDEBHBhFczejiuyw9aK&date=" + this.dateb, (JSONObject) null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try {
                    day2details.add("gggg");
                    day2details.add(response.getString("date"));
                    day2details.add(response.getString("explanation"));
                    day2details.add(response.getString("title"));
                    day2details.add(response.getString("url"));

                    GlideApp.with(getApplicationContext()).load(response.getString("url")).centerCrop().into((ImageView)image2);
                    date2.setText(response.getString("date"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        });
        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(0, "https://api.nasa.gov/planetary/apod?api_key=IkBHUM74New6dImwPRdaJsDEBHBhFczejiuyw9aK&date=" + this.datec, (JSONObject) null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try {
                    day3details.add("");
                    day3details.add(response.getString("date"));
                    day3details.add(response.getString("explanation"));
                    day3details.add(response.getString("title"));
                    day3details.add(response.getString("url"));
                    //Glide.with(getApplicationContext()).load(day3details.get(4)).apply(RequestOptions.circleCropTransform()).apply(RequestOptions.centerCropTransform()).into((ImageView)image3);
                    GlideApp.with(getApplicationContext()).load(response.getString("url")).centerCrop().into((ImageView)image3);
                    date3.setText(response.getString("date"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        });
        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(0, "https://api.nasa.gov/planetary/apod?api_key=IkBHUM74New6dImwPRdaJsDEBHBhFczejiuyw9aK&date=" + this.dated, (JSONObject) null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try {
                    day4details.add("");
                    day4details.add(response.getString("date"));
                    day4details.add(response.getString("explanation"));
                    day4details.add(response.getString("title"));
                    day4details.add(response.getString("url"));
                   // Glide.with(getApplicationContext()).load(day4details.get(4)).apply(RequestOptions.circleCropTransform()).into((ImageView) image4);
                    GlideApp.with(getApplicationContext()).load(response.getString("url")).centerCrop().into((ImageView)image4);
                    date4.setText(response.getString("date"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        });
        Response.Listener<JSONObject> r15 = new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try {
                    day5details.add("");
                    day5details.add(response.getString("date"));
                    day5details.add(response.getString("explanation"));
                    day5details.add(response.getString("title"));
                    day5details.add(response.getString("url"));
                   // Glide.with(getApplicationContext()).load(response.getString("url")).apply(RequestOptions.circleCropTransform()).into((ImageView) image5);
                    GlideApp.with(getApplicationContext()).load(day5details.get(4)).centerCrop().into((ImageView)image5);
                    date5.setText(response.getString("date"));
                   // container1.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        LinearLayout linearLayout = container1;
        requestQueue.add(date1request);
        requestQueue.add(jsonObjectRequest);
        requestQueue.add(jsonObjectRequest2);
        requestQueue.add(jsonObjectRequest3);
        requestQueue.add(new JsonObjectRequest(0, "https://api.nasa.gov/planetary/apod?api_key=IkBHUM74New6dImwPRdaJsDEBHBhFczejiuyw9aK&date=" + this.datee, (JSONObject) null, r15, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }));

        this.image1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                active = "one";
                showDate1();
            }
        });
        this.image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                active = "two";
                showDate2();
            }
        });
        this.image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                active = "three";
                showDate3();
            }
        });
        this.image4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                active = "four";
                showDate4();
            }
        });
        this.image5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                active = "five";
                shoeDate5();
            }
        });
        this.download.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(getParent(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                } else if (active.equals("one")) {
                    new Downloader().execute(new String[]{day1details.get(4), day1details.get(3)});
                    Toast.makeText(getApplicationContext(), "downloading image", Toast.LENGTH_LONG).show();
                } else if (active.equals("two")) {
                    new Downloader().execute(new String[]{day2details.get(4), day2details.get(3)});
                    Toast.makeText(getApplicationContext(), "downloading image", Toast.LENGTH_LONG).show();
                } else if (active.equals("three")) {
                    new Downloader().execute(new String[]{day3details.get(4), day3details.get(3)});
                    Toast.makeText(getApplicationContext(), "downloading image", Toast.LENGTH_LONG).show();
                } else if (active.equals("four")) {
                    new Downloader().execute(new String[]{day4details.get(4), day4details.get(3)});
                    Toast.makeText(getApplicationContext(), "downloading image", Toast.LENGTH_LONG).show();
                } else if (active.equals("five")) {
                    new Downloader().execute(new String[]{day5details.get(4), day5details.get(3)});
                    Toast.makeText(getApplicationContext(), "downloading image", Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    public  void saveImage(){}

    @SuppressLint("SetTextI18n")
    public void showDate1() {
        try {
           // Glide.with(getApplicationContext()).load(this.day1details.get(4)).into(this.pod);
            GlideApp.with(getApplicationContext()).load(day1details.get(4)).into(pod);
            TextView textView = this.description;
            textView.setText(this.day1details.get(3) + "\n" + this.day1details.get(2));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showDate2() {
        try {
           // Glide.with(getApplicationContext()).load(this.day2details.get(4)).into(this.pod);
            GlideApp.with(getApplicationContext()).load(day2details.get(4)).into(pod);
            TextView textView = this.description;
            textView.setText(this.day2details.get(3) + "\n" + this.day2details.get(2));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showDate3() {
        try {
           // Glide.with(getApplicationContext()).load(this.day3details.get(4)).into(this.pod);
            GlideApp.with(getApplicationContext()).load(day3details.get(4)).into(pod);
            TextView textView = this.description;
            textView.setText(this.day3details.get(3) + "\n" + this.day3details.get(2));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showDate4() {
        try {
          //  Glide.with(getApplicationContext()).load(this.day4details.get(4)).into(this.pod);
            GlideApp.with(getApplicationContext()).load(day4details.get(4)).into(pod);
            TextView textView = this.description;
            textView.setText(this.day4details.get(3) + "\n" + this.day4details.get(2));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void shoeDate5() {
        try {
           // Glide.with(getApplicationContext()).load(this.day5details.get(4)).into(this.pod);
            GlideApp.with(getApplicationContext()).load(day5details.get(4)).into(pod);
            TextView textView = this.description;
            textView.setText(this.day5details.get(3) + "\n" + this.day5details.get(2));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


     class Downloader extends AsyncTask<String, Void, String> {
        String iname;

        Downloader() {
        }

        public void downloadFile(String uRl, String iname2) {
            this.iname = iname2;
            File direct = new File(Environment.getExternalStorageDirectory() + "/Nasar");
            if (!direct.exists()) {
                direct.mkdirs();
            }
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(uRl));
                String iname3 = iname2.replace(" ", "-").toLowerCase();
                DownloadManager.Request description = request.setAllowedNetworkTypes(3).setAllowedOverRoaming(false).setTitle(iname3).setDescription("Astrology Image of the day");
                description.setDestinationInExternalPublicDir("/Nasar", iname3 + ".jpg");
                ((DownloadManager) getSystemService(DOWNLOAD_SERVICE)).enqueue(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strings) {
            this.iname = strings[1];
            downloadFile(strings[0], this.iname);
            return "success";
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String s) {
            saveImage();
        }
    }
}

