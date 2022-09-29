package com.example.vegetablelife2.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vegetablelife2.R;
import com.example.vegetablelife2.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {


    private FragmentGalleryBinding binding;
    private Bundle bundle;
    private ContentView contentView;
    Spinner dropdown;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);


        dropdown = rootView.findViewById(R.id.sp01);
        initspinnerfooter();


        return rootView;

        /*binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvSpinner;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;*/

    }


    //https://stackoverflow.com/questions/52233359/a-spinner-inside-a-fragment
    private void initspinnerfooter() {


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.opcion_profesional, android.R.layout.simple_spinner_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                dropdown.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }








    private void setContentView(int fragment_gallery) {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}