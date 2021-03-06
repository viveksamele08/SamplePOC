package geeksforandroidgeeks.com.spapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    private TextView home, feedback, faq, aboutSp;
    private ImageView close, sign_out;
    private DrawerLayout drawer;
    private FloatingActionButton fab;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fab.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().add(R.id.content, new HomeFragment(),"Home").commit();
                              return true;
                case R.id.navigation_dashboard:
                    fab.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new DashboardFragment(),"Dash").commit();
                    return true;
                case R.id.navigation_notifications:
                    fab.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new NotificatrionsFragment(),"Notification").commit();
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        home = (TextView) findViewById(R.id.home);
        faq = (TextView) findViewById(R.id.faq);
        feedback = (TextView) findViewById(R.id.feedback);
        aboutSp = (TextView) findViewById(R.id.aboutSP);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        sign_out = (ImageView) findViewById(R.id.sign_out);

        home.setOnClickListener(this);
        faq.setOnClickListener(this);
        feedback.setOnClickListener(this);
        aboutSp.setOnClickListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        close = (ImageView) findViewById(R.id.close);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.home) {
            home.setTypeface(null, Typeface.BOLD);
            feedback.setTypeface(null, Typeface.NORMAL);
            faq.setTypeface(null, Typeface.NORMAL);
            aboutSp.setTypeface(null, Typeface.NORMAL);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        } else if (view.getId() == R.id.feedback) {
            home.setTypeface(null, Typeface.NORMAL);
            feedback.setTypeface(null, Typeface.BOLD);
            faq.setTypeface(null, Typeface.NORMAL);
            aboutSp.setTypeface(null, Typeface.NORMAL);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        } else if (view.getId() == R.id.faq) {
            home.setTypeface(null, Typeface.NORMAL);
            feedback.setTypeface(null, Typeface.NORMAL);
            faq.setTypeface(null, Typeface.BOLD);
            aboutSp.setTypeface(null, Typeface.NORMAL);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        } else if (view.getId() == R.id.aboutSP) {
            home.setTypeface(null, Typeface.NORMAL);
            feedback.setTypeface(null, Typeface.NORMAL);
            faq.setTypeface(null, Typeface.NORMAL);
            aboutSp.setTypeface(null, Typeface.BOLD);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        }
    }

}
