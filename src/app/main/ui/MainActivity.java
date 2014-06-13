package app.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import app.main.R;
import app.main.url.*;

public class MainActivity extends FragmentActivity {
	SlidingMenu mSlidingMenu;
	LeftFragment leftFragment;
	RightFragment rightFragment;
	SampleListFragment centerFragment;
	FragmentTransaction t;

	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.left_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.right_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.center_frame, null));

		t = this.getSupportFragmentManager().beginTransaction();
		leftFragment = new LeftFragment();
		rightFragment = new RightFragment();
		t.replace(R.id.left_frame, leftFragment);
		t.replace(R.id.right_frame, rightFragment);

		centerFragment = new SampleListFragment();
		t.replace(R.id.center_frame, centerFragment);
		t.commit();

	}

	public void llronclick(View v) {
		switch (v.getId()) {
		case R.id.llr_energy_management:
			Intent intent = new Intent(this, test.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

}
