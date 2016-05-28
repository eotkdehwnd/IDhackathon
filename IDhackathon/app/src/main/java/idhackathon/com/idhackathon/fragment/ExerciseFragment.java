package idhackathon.com.idhackathon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import idhackathon.com.idhackathon.R;

/**
 * Created by Kim on 2016-05-29.
 */
public class ExerciseFragment extends Fragment {

    private View cView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        cView = inflater.inflate(R.layout.fragment_exercise, container, false);
        return cView;

    }
}
