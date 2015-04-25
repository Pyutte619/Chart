package com.app.dyoni.chart;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set entry of pie chart
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry((float) 20.0, 0));
        entries.add(new Entry((float) 30.0, 1));

        entries.add(new Entry((float) 20.5, 2));
        entries.add(new Entry((float) 10.1, 3));
        entries.add(new Entry((float) 50.0, 4));
        entries.add(new Entry((float) 17.0, 5));

        int colors[] = {Color.parseColor("#DCDEE0"),Color.parseColor("#466A80"),Color.parseColor("#0078CA"),Color.parseColor("#5BC2E7"), Color.parseColor("#99E4FF"),Color.parseColor("#ffffff")};
        PieDataSet dataset = new PieDataSet(entries, "# of Calls");
        dataset.setColors(colors);
        dataset.setSliceSpace(3f);

        //create label of chart
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
      labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        //display the pie chart
        PieChart chart1 = new PieChart(this);
        chart1.setLayoutParams(new LinearLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0.5f));
        chart1.setHoleRadius(40f);
        chart1.setHoleColorTransparent(false);
        chart1.setDrawHoleEnabled(true);
        chart1.setUsePercentValues(true);
        chart1.setHoleColor(Color.WHITE);
        PieChart chart2 = new PieChart(this);
        chart2.setLayoutParams(new LinearLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0.5f));
        LinearLayout chart = (LinearLayout)findViewById(R.id.chart);
        chart.addView(chart1);
        //chart.addView(chart2);

        PieData data = new PieData(labels, dataset);
        chart1.setData(data);
        chart2.setData(data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
