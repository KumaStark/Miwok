/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        setOnClickListeners(findViewById(R.id.menu));
    }

    private void setOnClickListeners(View view) {
        ViewGroup list = (ViewGroup) view;
        for (int i = 0; i < list.getChildCount(); i++) {
            View listItem = list.getChildAt(i);
            listItem.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view){
        int viewID = view.getId();
        String viewText = ((TextView) view).getText()+"("+viewID+")";
        Intent i = new Intent();
        switch(view.getId()) {
            case R.id.numbers:
                i.setClass(this,NumbersActivity.class);
                break;
            case R.id.colors:
                i.setClass(this,ColorsActivity.class);
                break;
            case R.id.family:
                i.setClass(this,FamilyActivity.class);
                break;
            case R.id.phrases:
                i.setClass(this,PhrasesActivity.class);
                break;
            case R.id.button_function_test:
                i.setClass(this,MediaPlayerActivity.class);
                break;
            default:
                break;
        }
        if(i.resolveActivity(getPackageManager()) != null) {
            //Toast.makeText(view.getContext(),viewText,Toast.LENGTH_SHORT).show();
            startActivity(i);
        }else{
            Toast.makeText(view.getContext(),viewText + " Not Ready",Toast.LENGTH_SHORT).show();
        }
    }
}