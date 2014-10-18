package com.example.carcreator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import com.example.utils.ISettings_;
import com.example.utils.Utils;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import static com.example.utils.Utils.log;

@EActivity(R.layout.settings_screen)
public class ASettings extends Activity {

	@Pref
	ISettings_ myPrefs;

	@ViewById
	CheckBox cbSingle, cbMarried;

	@ViewById
	EditText etUsrName, etUsrSurname;

	@ViewById
	Button btnSave;

	@ViewById
	RadioButton rbSingle, rbMarried;

	public boolean state;

	@CheckedChange
	void cbSingle(CompoundButton hello, boolean isChecked) {
		if (state == true) {
			cbSingle.setChecked(true);
			return;
		}
		if (cbSingle.isChecked() == true) {

			cbMarried.setChecked(false);
		} else {
			cbMarried.setChecked(true);
		}
	}

	@Click({ R.id.rbSingle, R.id.rbMarried })
	void radioButtonsClickListener(View clickedView) {
		boolean checked = ((RadioButton) clickedView).isChecked();

		switch (clickedView.getId()) {
		case R.id.rbSingle:
			if (checked)
				log("Single");
			break;

		case R.id.rbMarried:
			if (checked)
				log("Married");
			break;
		}

	}

	@CheckedChange
	void cbMarried(CompoundButton hello, boolean isChecked) {
		if (state == true) {
			cbMarried.setChecked(true);
			return;
		}
		if (cbMarried.isChecked() == true) {
			cbSingle.setChecked(false);
		} else {
			cbSingle.setChecked(true);
		}

	}

	@AfterViews
	void afterViews() {
		cbSingle.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					state = cbSingle.isChecked();
				}
				return false;
			}
		});

		cbMarried.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					state = cbMarried.isChecked();
				}
				return false;
			}
		});

		String name = myPrefs.name().get();
		String surname = myPrefs.surname().get();
		boolean maritalStatus = myPrefs.maritalStatus().get();

		etUsrName.setText(name);
		etUsrSurname.setText(surname);
		cbMarried.setChecked(maritalStatus);

	}

	@Click
	void btnSave() {
		myPrefs.name().put(etUsrName.getText().toString());
		myPrefs.surname().put(etUsrSurname.getText().toString());
		myPrefs.maritalStatus().put(cbMarried.isChecked());

		String name = myPrefs.name().get();
		String surname = myPrefs.surname().get();
		boolean maritalStatus = myPrefs.maritalStatus().get();
		Utils.log(name + " " + surname + " " + maritalStatus);

	}

}
