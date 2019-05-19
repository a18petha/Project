package com.example.project;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Scorepoint> match = new ArrayList<>();
    private ArrayAdapter<String> adapter;



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_action_name);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.list_item_text,
                R.id.list_item_textview);

        ListView my_listview = (ListView) findViewById(R.id.my_listview);
        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Scoredetails.class);
                intent.putExtra("location", match.get(i).getLocation());
                intent.putExtra("id", match.get(i).getId());
                intent.putExtra("league", match.get(i).getLeague());
                intent.putExtra("lagett", match.get(i).getLagett());
                intent.putExtra("lagtvå", match.get(i).getLagtvå());
                intent.putExtra("date", match.get(i).getDate());
                intent.putExtra("imageone", match.get(i).getImageone());
                intent.putExtra("imagetwo", match.get(i).getImagetwo());
                intent.putExtra("lagettpoints", match.get(i).getLagettpoints());
                intent.putExtra("lagtvåpoints", match.get(i).getLagtvåpoints());
                startActivity(intent);
            }
        });

        new FetchData().execute();

    }


    public boolean onCreateOptionsMenu(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            adapter.clear();
            new FetchData().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            adapter.clear();
            new FetchData().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class FetchData extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... params) {
            // These two variables need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;

            try {
                // Construct the URL for the Internet service
                URL url = new URL("http://wwwlab.iit.his.se/a18petha/Andriod_Studio/Project/results.php");

                // Create the request to the PHP-service, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in
                // attempting to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);

            Log.d("PetersDebug", "Debug start");
            Log.d("PetersDebug", o);

            try {

                JSONArray json1 = new JSONArray(o);

                for (int i = 0; i < json1.length(); i++) {
                    adapter.add(json1.getJSONObject(i).getString("ID"));
                    match.add(new Scorepoint(
                            json1.getJSONObject(i).getString("location"),
                            json1.getJSONObject(i).getString("ID"),
                            json1.getJSONObject(i).getString("league"),
                            json1.getJSONObject(i).getString("lagett"),
                            json1.getJSONObject(i).getString("lagtvo"),
                            json1.getJSONObject(i).getString("date"),
                            json1.getJSONObject(i).getString("imageone"),
                            json1.getJSONObject(i).getString("imagetwo"),
                            json1.getJSONObject(i).getInt("lagettpoints"),
                            json1.getJSONObject(i).getInt("lagtvopoints")
                    ));

                }


            } catch (JSONException e) {
                Log.e("brom", "E:" + e.getMessage());
            }

        }

    }


}
