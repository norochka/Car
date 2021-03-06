//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.example.carcreator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.carcreator.R.layout;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class ACarsList_
    extends ACarsList
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.activity_acars_list);
    }

    private void init_(Bundle savedInstanceState) {
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

    public static ACarsList_.IntentBuilder_ intent(Context context) {
        return new ACarsList_.IntentBuilder_(context);
    }

    public static ACarsList_.IntentBuilder_ intent(Fragment supportFragment) {
        return new ACarsList_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        btnGetOldestCar = ((Button) hasViews.findViewById(com.example.carcreator.R.id.btnGetOldestCar));
        etSearch = ((EditText) hasViews.findViewById(com.example.carcreator.R.id.etSearch));
        lvCars = ((ListView) hasViews.findViewById(com.example.carcreator.R.id.lvCars));
        btnGetCarBiggestEngine = ((Button) hasViews.findViewById(com.example.carcreator.R.id.btnGetCarBiggestEngine));
        btnGetListOfOldestCars = ((Button) hasViews.findViewById(com.example.carcreator.R.id.btnGetListOfOldestCars));
        {
            View view = hasViews.findViewById(com.example.carcreator.R.id.btnGetOldestCar);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        ACarsList_.this.btnGetOldestCar();
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(com.example.carcreator.R.id.btnGetCarBiggestEngine);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        ACarsList_.this.btnGetCarBiggestEngine();
                    }

                }
                );
            }
        }
        {
            AdapterView<?> view = ((AdapterView<?> ) hasViews.findViewById(com.example.carcreator.R.id.lvCars));
            if (view!= null) {
                view.setOnItemClickListener(new OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ACarsList_.this.lvCars(((String) parent.getAdapter().getItem(position)));
                    }

                }
                );
            }
        }
        {
            final TextView view = ((TextView) hasViews.findViewById(com.example.carcreator.R.id.etSearch));
            if (view!= null) {
                view.addTextChangedListener(new TextWatcher() {


                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        ACarsList_.this.etSearch();
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
            intent_ = new Intent(context, ACarsList_.class);
        }

        public IntentBuilder_(Fragment fragment) {
            fragmentSupport_ = fragment;
            context_ = fragment.getActivity();
            intent_ = new Intent(context_, ACarsList_.class);
        }

        public Intent get() {
            return intent_;
        }

        public ACarsList_.IntentBuilder_ flags(int flags) {
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
