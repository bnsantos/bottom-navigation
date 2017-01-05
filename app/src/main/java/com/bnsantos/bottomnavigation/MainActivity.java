package com.bnsantos.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.R.attr.type;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

  private BottomNavigationView mNavigationView;
  private BottomNavigationView mSubNavigationView;
  private int mTypeSelected;
  private int mSubTypeSelected;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    mSubNavigationView = (BottomNavigationView) findViewById(R.id.subBottomNavigation);
    initHome();
    mNavigationView.setOnNavigationItemSelectedListener(this);
    mSubNavigationView.setOnNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int itemId = item.getItemId();
    if(itemId == R.id.action_left || itemId == R.id.action_right){
      mSubTypeSelected = itemId;
    }else {
      mTypeSelected = itemId;
    }
    setFragment();
    return true;
  }

  private void initHome(){
    Menu menu = mNavigationView.getMenu();
    for (int i = 0; i< menu.size(); i++) {
      MenuItem menuItem = menu.getItem(i);
      if (menuItem.getItemId() == R.id.action_home) {
        menuItem.setChecked(true);
        break;
      }
    }

    Menu subMenu = mSubNavigationView.getMenu();
    for (int i = 0; i < subMenu.size(); i++) {
      MenuItem menuItem = menu.getItem(i);
      if (menuItem.getItemId() == R.id.action_left) {
        menuItem.setChecked(true);
        break;
      }
    }
    mTypeSelected = R.id.action_home;
    mSubTypeSelected = R.id.action_left;
    setFragment();
  }

  private void setFragment(){
    Fragment fragment = null;
    StringBuilder sb = new StringBuilder();
    switch (mSubTypeSelected){
      case R.id.action_left:
        sb.append(getString(R.string.left) + " - ");
        break;
      case R.id.action_right:
        sb.append(getString(R.string.right) + " - ");
        break;
    }
    switch (mTypeSelected) {
      case R.id.action_profile:
        fragment = MenuFragment.newInstance(sb.toString() + getString(R.string.profile), getResources().getColor(R.color.colorProfile));
        break;
      case R.id.action_home:
        fragment = MenuFragment.newInstance(sb.toString() + getString(R.string.home), getResources().getColor(R.color.colorHome));
        break;
      case R.id.action_settings:
        fragment = MenuFragment.newInstance(sb.toString() + getString(R.string.settings), getResources().getColor(R.color.colorSettings));
        break;
    }

    if (fragment != null) {
      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
      ft.replace(R.id.container, fragment, fragment.getTag());
      ft.commit();
    }
  }
}
