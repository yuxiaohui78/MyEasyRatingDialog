package com.aries.easyratingdialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aries.ratingdialog.EasyRatingDialog;


public class MainActivity extends Activity {

  EasyRatingDialog easyRatingDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    easyRatingDialog = new EasyRatingDialog(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    easyRatingDialog.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
    easyRatingDialog.showIfNeeded();
  }

  public void onClickRateNow(View view) {
    Intent intent = new Intent(this, TestActivity.class);
    startActivity(intent);
  }

  public void onClickNeverReminder(View view) {
    easyRatingDialog.showRatingDlg();
  }

  public EasyRatingDialog getEasyRatingDialog() {
    return easyRatingDialog;
  }
}
