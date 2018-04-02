package com.example.hp.hellosir.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.hellosir.R;
import com.example.hp.hellosir.fragment.Batch2013Fragment;
import com.example.hp.hellosir.fragment.Batch2014Fragment;
import com.example.hp.hellosir.fragment.Batch2015Fragment;
import com.example.hp.hellosir.fragment.Batch2016Fragment;
import com.example.hp.hellosir.fragment.Batch2017Fragment;
import com.example.hp.hellosir.fragment.SearchByNameFragment;
import com.example.hp.hellosir.fragment.SearchByRegFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(Batch2013Fragment.class);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Class fragment=null;
        if (id == R.id.nav_batch2013) {
            fragment=Batch2013Fragment.class;
            showFragment(fragment);
        }
        else if (id == R.id.nav_batch2014) {
            fragment=Batch2014Fragment.class;
            showFragment(fragment);
        }
        else if (id == R.id.nav_batch2015) {
            fragment=Batch2015Fragment.class;
            showFragment(fragment);
        }
        else if (id == R.id.nav_batch2016) {
            fragment=Batch2016Fragment.class;
            showFragment(fragment);
        }
        else if (id == R.id.nav_batch2017){
            fragment= Batch2017Fragment.class;
            showFragment(fragment);
        }
        else if (id == R.id.nav_searchByName) {
            fragment=SearchByNameFragment.class;
            showFragment(fragment);
        }
        else if (id == R.id.nav_searchByRegNo) {
            fragment=SearchByRegFragment.class;
            showFragment(fragment);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Class fragmentClass) {
        Fragment fragment=null;
        try {
            fragment=(Fragment)fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.FLStudent,fragment)
                .commit();

    }
}
