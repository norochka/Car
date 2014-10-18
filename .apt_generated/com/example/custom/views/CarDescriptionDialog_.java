//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.example.custom.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.example.carcreator.Car;
import com.example.carcreator.R.id;
import com.example.carcreator.R.layout;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;


/**
 * We use @SuppressWarning here because our java code
 * generator doesn't know that there is no need
 * to import OnXXXListeners from View as we already
 * are in a View.
 * 
 */
@SuppressWarnings("unused")
public final class CarDescriptionDialog_
    extends CarDescriptionDialog
    implements HasViews, OnViewChangedListener
{

    private boolean alreadyInflated_ = false;
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    public CarDescriptionDialog_(Context context, Car mashina) {
        super(context, mashina);
        init_();
    }

    public static CarDescriptionDialog build(Context context, Car mashina) {
        CarDescriptionDialog_ instance = new CarDescriptionDialog_(context, mashina);
        instance.onFinishInflate();
        return instance;
    }

    /**
     * The mAlreadyInflated_ hack is needed because of an Android bug
     * which leads to infinite calls of onFinishInflate()
     * when inflating a layout with a parent and using
     * the <merge /> tag.
     * 
     */
    @Override
    public void onFinishInflate() {
        if (!alreadyInflated_) {
            alreadyInflated_ = true;
            inflate(getContext(), layout.dialog_view_list_item, this);
            onViewChangedNotifier_.notifyViewChanged(this);
        }
        super.onFinishInflate();
    }

    private void init_() {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        etDoorsNum = ((EditText) hasViews.findViewById(id.etDoorsNum));
        etVolumeNum = ((EditText) hasViews.findViewById(id.etVolumeNum));
        etYearsNum = ((EditText) hasViews.findViewById(id.etYearsNum));
        btnSaveCh = ((Button) hasViews.findViewById(id.btnSaveCh));
        etCarName = ((EditText) hasViews.findViewById(id.etCarName));
        {
            View view = hasViews.findViewById(id.btnSaveCh);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        CarDescriptionDialog_.this.btnSaveCh();
                    }

                }
                );
            }
        }
        afterViews();
    }

}