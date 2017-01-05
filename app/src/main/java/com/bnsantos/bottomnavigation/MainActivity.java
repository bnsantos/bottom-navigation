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

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

  private BottomNavigationView mNavigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    initHome();
    mNavigationView.setOnNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    setFragment(item.getItemId());
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
    setFragment(R.id.action_home);
  }

  private void setFragment(int type){
    Fragment fragment = null;
    switch (type) {
      case R.id.action_profile:
        fragment = MenuFragment.newInstance(getString(R.string.profile), getResources().getColor(R.color.colorProfile));
        break;
      case R.id.action_home:
        fragment = MenuFragment.newInstance(getString(R.string.home), getResources().getColor(R.color.colorHome));
        break;
      case R.id.action_settings:
        fragment = MenuFragment.newInstance(getString(R.string.settings), getResources().getColor(R.color.colorSettings));
        break;
    }

    if (fragment != null) {
      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
      ft.replace(R.id.container, fragment, fragment.getTag());
      ft.commit();
    }
  }
}
