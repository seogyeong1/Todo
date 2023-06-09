package hnu.multimedia.todo.ui.individual;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IndividualViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public IndividualViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}