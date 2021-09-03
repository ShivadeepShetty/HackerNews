package com.app.newshacker.ui;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.app.newshacker.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

public class HomeActivity extends AppCompatActivity implements HomeFragment.ActivityListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadHomeFragment();
    }

    private void loadHomeFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, HomeFragment.class, null)
                .commit();
    }

    @Override
    public void loadItem(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("id", id );
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, NewsDetailFragment.class, bundle)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                HomeFragment homeFragment = ((HomeFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout));
                if(homeFragment!=null){
                    homeFragment.onItemSearched(query);
                }

                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
