package hnu.multimedia.todo.ui.individual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import hnu.multimedia.todo.databinding.FragmentIndividualBinding;

public class IndividualFragment extends Fragment {

    private FragmentIndividualBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndividualViewModel notificationsViewModel =
                new ViewModelProvider(this).get(IndividualViewModel.class);

        binding = FragmentIndividualBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}