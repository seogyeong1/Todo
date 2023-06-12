package hnu.multimedia.todo.ui.calender;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalenderViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CalenderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}