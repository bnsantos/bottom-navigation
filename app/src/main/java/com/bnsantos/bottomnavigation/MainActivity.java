package com.bnsantos.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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
    mNavigationView.setOnNavigationItemSelectedListener(this);
    initHome();
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_profile:
        Toast.makeText(this, "TODO profile", Toast.LENGTH_SHORT).show();
        break;
      case R.id.action_home:
        Toast.makeText(this, "TODO home", Toast.LENGTH_SHORT).show();
        break;
      case R.id.action_settings:
        Toast.makeText(this, "TODO settings", Toast.LENGTH_SHORT).show();
        break;
    }
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
  }
}
