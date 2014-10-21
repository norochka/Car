//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.example.carcreator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import com.example.carcreator.R.id;
import com.example.carcreator.R.layout;
import com.example.utils.ISettings_;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class ASettings_
    extends ASettings
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.settings_screen);
    }

    private void init_(Bundle savedInstanceState) {
        myPrefs = new ISettings_(this);
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static ASettings_.IntentBuilder_ intent(Context context) {
        return new ASettings_.IntentBuilder_(context);
    }

    public static ASettings_.IntentBuilder_ intent(Fragment supportFragment) {
        return new ASettings_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        btnSave = ((Button) hasViews.findViewById(id.btnSave));
        rbMarried = ((RadioButton) hasViews.findViewById(id.rbMarried));
        cbSingle = ((CheckBox) hasViews.findViewById(id.cbSingle));
        etUsrName = ((EditText) hasViews.findViewById(id.etUsrName));
        cbMarried = ((CheckBox) hasViews.findViewById(id.cbMarried));
        etUsrSurname = ((EditText) hasViews.findViewById(id.etUsrSurname));
        rbSingle = ((RadioButton) hasViews.findViewById(id.rbSingle));
        {
            View view = hasViews.findViewById(id.btnSave);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        ASettings_.this.btnSave();
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(id.rbSingle);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        ASettings_.this.radioButtonsClickListener(view);
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(id.rbMarried);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        ASettings_.this.radioButtonsClickListener(view);
                    }

                }
                );
            }
        }
        {
            CompoundButton view = ((CompoundButton) hasViews.findViewById(id.cbSingle));
            if (view!= null) {
                view.setOnCheckedChangeListener(new OnCheckedChangeListener() {


                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ASettings_.this.cbSingle(buttonView, isChecked);
                    }

                }
                );
            }
        }
        {
            CompoundButton view = ((CompoundButton) hasViews.findViewById(id.cbMarried));
            if (view!= null) {
                view.setOnCheckedChangeListener(new OnCheckedChangeListener() {


                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ASettings_.this.cbMarried(buttonView, isChecked);
                    }

                }
                );
            }
        }
        afterViews();
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;
        private Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, ASettings_.class);
        }

        public IntentBuilder_(Fragment fragment) {
            fragmentSupport_ = fragment;
            context_ = fragment.getActivity();
            intent_ = new Intent(context_, ASettings_.class);
        }

        public Intent get() {
            return intent_;
        }

        public ASettings_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent_, requestCode);
            } else {
                if (context_ instanceof Activity) {
                    ((Activity) context_).startActivityForResult(intent_, requestCode);
                } else {
                    context_.startActivity(intent_);
                }
            }
        }

    }

}
