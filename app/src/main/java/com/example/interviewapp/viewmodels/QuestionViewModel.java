package com.example.interviewapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.interviewapp.data.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private  MutableLiveData<List<Question>> mMutableLiveData;
    private List<Question> mQuestionList;
    public QuestionViewModel(@NonNull Application application) {
        super(application);
        if(mMutableLiveData==null){
            mMutableLiveData = new MutableLiveData<>();
            initData();
            mMutableLiveData.postValue(mQuestionList);
        }
    }

    public MutableLiveData<List<Question>> getMutableLiveData() {
        return mMutableLiveData;
    }

    private void initData() {
        mQuestionList = new ArrayList<>();
        mQuestionList.add(new Question(1,"Mvvm là gì","MVVM là viết tắt của Model - View - ViewModel, đây là mô hình hỗ trợ two-way data binding giữa View và View Model. Cụ thể mô hình MVVM được trình bày như sau: \n" +
                "\n" +
                "- View\n" +
                "Tương tự như trong mô hình MVC, View là phần giao diện của ứng dụng để hiển thị dữ liệu và nhận tương tác của người dùng. Một điểm khác biệt so với các ứng dụng truyền thống là View trong mô hình này tích cực hơn, nó có khả năng thực hiện các hành vi và phản hồi lại người dùng thông qua tính năng binding, command\n" +
                "\n" +
                "- Model\n" +
                "Cũng tương tự như trong mô hình MVC, Model là các đối tượng giúp truy xuất và thao tác trên dữ liệu thực sự\n" +
                "\n" +
                "mvvm-la-gi-1.png\n" +
                "\n" +
                "MVVM là gì?\n" +
                "\n" +
                "- View Model\n" +
                "Là lớp trung gian giữa View và Model. View Model có thể được xem là thành phần thay thế cho Controller trong mô hình MVC. Nó chứa các mã lệnh thực hiện Data Binding, Command. Một điểm cần lưu ý là trong mô hình MVVM, các tầng bên dưới sẽ không biết được các thông tin gì về các tầng trên của nó. Như hình minh họa dưới đây:\n" +
                "\n" +
                "- Một định nghĩa khác về ViewModel trong MVVM\n" +
                "ViewModel sẽ đảm nhận công việc đồng bộ dữ liệu từ Model lên View. Mối quan hệ giữa View và View-Model là View sẽ được ánh xạ tới View Model nhưng ViewModel lại không biết thông tin gì về View. nó được ẩn giấu qua cách sử dụng Data-binding và cơ chế của mô hình Observer, một ViewModel có thể được ánh xạ từ nhiều View" +
                "2. Cấu trúc thư mục trong MVVM\n" +
                "Thông thường khi sử dụng với MVVM chúng ta nên tạo 3 thư mục chính chứa các file code liên quan\n" +
                "\n" +
                "- Views\n" +
                "Tại đây chứa các file giao diện và mỗi file giao diện đều có class code-behind đi kèm. Đặc biệt file code-behind ta sẽ không sử dụng đến, mọi điều cần làm sẽ chuyển xuống class ViewModel. Tất nhiên là bạn có thể code trong file code-behind của XAML nhưng đồng nghĩa điều đó sẽ phá vỡ quy ước của MVVM. Bạn có thể khai báo thuộc tính datacontext hoặc vài thiết lập khác nhưng nên hạn chế tối thiểu code ở đây. Views được sử dụng để kết hợp với các mô hình MVVM,...  Nó dùng để cung cấp một sự chia tách gọn gàng của khái niệm giữa UI và presentation logic và data\n" +
                "\n" +
                "- Models\n" +
                "Trong thư mục Models tạo các tầng chứa dữ liệu và bất kỳ liên kết validation, logic nghiệp vụ để chắc chắn tính toàn vẹn của data, bạn có thể tách ra như một Repositories khác, chúng được dùng như một phần của mô hình MVVM\n" +
                "\n" +
                "- ViewModels\n" +
                "Thông thường trong một file giao diện thì ta tạo ra một class View Models tương ứng (có đôi lúc ta tạo nhiều class phụ giúp tinh giản file code và gọi chúng trong class ViewModels chính)\n" +
                "\n" +
                "ViewModels sẽ sử dụng các models nếu cần định nghĩa dữ liệu. Sự liên kết giữa View-ViewModel giúp chúng gửi và nhận dữ liệu, để hiểu rõ ta cần tìm hiểu các khái niệm về Binding, DataContext, Behaviors SDK, nhờ đó ta tách code-behind của View và đưa xuống View Model\n" +
                "\n" +
                "Ngoài ra một lớp ViewModels chứa presentation logic và state của ứng dụng. ViewModel cần chứa các chức năng của ứng dụng. ViewModels định nghĩa properties, commands và events để chuyển đổi controls trong view cần data-bind"));
    }
}
