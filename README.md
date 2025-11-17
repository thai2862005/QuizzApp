# QuizzApp

<div align="center">

![Version](https://img.shields.io/badge/version-1.0-blue.svg)
![API Level](https://img.shields.io/badge/API-26%2B-brightgreen.svg)
![Target SDK](https://img.shields.io/badge/Target%20SDK-36-green.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

**Ứng dụng Quiz tương tác trên Android với giao diện hiện đại và trải nghiệm người dùng mượt mà**

[Tính năng](#tính-năng) • [Yêu cầu hệ thống](#yêu-cầu-hệ-thống) • [Cài đặt](#cài-đặt) • [Cấu trúc dự án](#cấu-trúc-dự-án) • [Công nghệ](#công-nghệ)

</div>

---

## 📋 Giới thiệu

QuizzApp là một ứng dụng Android toàn diện cho phép người dùng:
- Tham gia các cuộc thi trắc nghiệm đa dạng
- Được xếp hạng trên bảng xếp hạng toàn cầu
- Theo dõi kết quả và tiến trình học tập
- Chọn từ nhiều danh mục câu hỏi khác nhau

Ứng dụng được xây dựng với kiến trúc modular, cho phép phát triển và bảo trì dễ dàng các tính năng mới.

---

## ✨ Tính năng chính

### 🔐 Xác thực
- **Đăng nhập/Đăng ký**: Hỗ trợ xác thực người dùng an toàn
- **Quản lý tài khoản**: Lưu trữ hồ sơ người dùng

### 🎯 Chức năng Quiz
- **Nhiều danh mục**: Các cuộc thi từ các lĩnh vực khác nhau
- **Câu hỏi đa dạng**: Định dạng trắc nghiệm với các lựa chọn
- **Tính điểm thực tế**: Tính toán điểm số tức thời
- **Phản hồi ngay lập tức**: Xem kết quả sau khi hoàn thành

### 📊 Bảng xếp hạng
- **Bảng xếp hạng toàn cầu**: So sánh hiệu suất với người chơi khác
- **Thống kê cá nhân**: Xem điểm số và lịch sử

### 🎨 Giao diện người dùng
- **Thiết kế Material Design**: Giao diện hiện đại và thân thiện
- **Điều hướng tuyệt vời**: Chuyển động mượt mà giữa các màn hình
- **Tối ưu hóa cho các thiết bị**: Hỗ trợ nhiều kích thước màn hình

---

## 🛠️ Yêu cầu hệ thống

### Phát triển
- **Android Studio**: Phiên bản mới nhất
- **JDK**: Java 11 hoặc cao hơn
- **Gradle**: 8.12.0
- **Android SDK**: API Level 26 trở lên

### Chạy ứng dụng
- **Phiên bản Android**: Android 8.0 (API 26) trở lên
- **RAM**: Tối thiểu 2GB
- **Kết nối Internet**: Yêu cầu để tải dữ liệu

---

## 📦 Cài đặt

### 1. Clone dự án
```bash
git clone https://github.com/thai2862005/QuizzApp.git
cd QuizzApp
```

### 2. Mở trong Android Studio
```bash
# Nếu bạn đã cài đặt Android Studio từ dòng lệnh
studio . &
```

### 3. Cấu hình Gradle
Dự án sẽ tự động tải các phụ thuộc cần thiết. Nếu cần, hãy đồng bộ Gradle:
```bash
./gradlew sync
```

### 4. Build dự án
```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease
```

### 5. Chạy ứng dụng
- Kết nối thiết bị Android hoặc khởi động một trình giả lập
- Nhấn **Run** trong Android Studio hoặc sử dụng:
```bash
./gradlew installDebug
```

---

## 🏗️ Cấu trúc dự án



```

├── 📁 app/
│   ├── 📁 categories_screen/
│   │   ├── 📁 src/
│   │   │   ├── 📁 androidTest/
│   │   │   │   └── 📁 java/
│   │   │   │       └── 📁 com/
│   │   │   │           └── 📁 example/
│   │   │   │               └── 📁 categories_screen/
│   │   │   │                   └── ☕ ExampleInstrumentedTest.java
│   │   │   ├── 📁 main/
│   │   │   │   ├── 📁 java/
│   │   │   │   │   └── 📁 com/
│   │   │   │   │       └── 📁 example/
│   │   │   │   │           └── 📁 categories_screen/
│   │   │   │   │               └── ☕ MainActivity.java
│   │   │   │   ├── 📁 res/
│   │   │   │   │   ├── 📁 drawable/
│   │   │   │   │   │   ├── ⚙️ bg_choose.xml
│   │   │   │   │   │   ├── ⚙️ bg_ct.xml
│   │   │   │   │   │   ├── ⚙️ bg_his.xml
│   │   │   │   │   │   ├── ⚙️ bg_monhoc.xml
│   │   │   │   │   │   ├── ⚙️ bg_op.xml
│   │   │   │   │   │   ├── ⚙️ bg_op2.xml
│   │   │   │   │   │   ├── ⚙️ bg_op3.xml
│   │   │   │   │   │   ├── ⚙️ bg_op4.xml
│   │   │   │   │   │   ├── ⚙️ bg_sp.xml
│   │   │   │   │   │   ├── ⚙️ border_rd.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   │   └── ⚙️ ic_launcher_foreground.xml
│   │   │   │   │   ├── 📁 layout/
│   │   │   │   │   │   └── ⚙️ activity_main.xml
│   │   │   │   │   ├── 📁 mipmap-anydpi-v26/
│   │   │   │   │   │   ├── ⚙️ ic_ball.xml
│   │   │   │   │   │   ├── ⚙️ ic_ball_round.xml
│   │   │   │   │   │   ├── ⚙️ ic_book.xml
│   │   │   │   │   │   ├── ⚙️ ic_book_round.xml
│   │   │   │   │   │   ├── ⚙️ ic_kinh.xml
│   │   │   │   │   │   ├── ⚙️ ic_kinh_round.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher_round.xml
│   │   │   │   │   │   ├── ⚙️ ic_td.xml
│   │   │   │   │   │   ├── ⚙️ ic_td_round.xml
│   │   │   │   │   │   ├── ⚙️ ic_vector.xml
│   │   │   │   │   │   └── ⚙️ ic_vector_round.xml
│   │   │   │   │   ├── 📁 mipmap-hdpi/
│   │   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector_foreground.webp
│   │   │   │   │   │   └── 🖼️ ic_vector_round.webp
│   │   │   │   │   ├── 📁 mipmap-mdpi/
│   │   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector_foreground.webp
│   │   │   │   │   │   └── 🖼️ ic_vector_round.webp
│   │   │   │   │   ├── 📁 mipmap-xhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector_foreground.webp
│   │   │   │   │   │   └── 🖼️ ic_vector_round.webp
│   │   │   │   │   ├── 📁 mipmap-xxhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector_foreground.webp
│   │   │   │   │   │   └── 🖼️ ic_vector_round.webp
│   │   │   │   │   ├── 📁 mipmap-xxxhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_kinh_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector.webp
│   │   │   │   │   │   ├── 🖼️ ic_vector_foreground.webp
│   │   │   │   │   │   └── 🖼️ ic_vector_round.webp
│   │   │   │   │   ├── 📁 values/
│   │   │   │   │   │   ├── ⚙️ colors.xml
│   │   │   │   │   │   ├── ⚙️ ic_ball_background.xml
│   │   │   │   │   │   ├── ⚙️ ic_book_background.xml
│   │   │   │   │   │   ├── ⚙️ ic_kinh_background.xml
│   │   │   │   │   │   ├── ⚙️ ic_td_background.xml
│   │   │   │   │   │   ├── ⚙️ ic_vector_background.xml
│   │   │   │   │   │   ├── ⚙️ strings.xml
│   │   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   │   └── 📁 values-night/
│   │   │   │   │       └── ⚙️ themes.xml
│   │   │   │   ├── ⚙️ AndroidManifest.xml
│   │   │   │   ├── 🖼️ ic_ball-playstore.png
│   │   │   │   ├── 🖼️ ic_book-playstore.png
│   │   │   │   ├── 🖼️ ic_kinh-playstore.png
│   │   │   │   ├── 🖼️ ic_td-playstore.png
│   │   │   │   └── 🖼️ ic_vector-playstore.png
│   │   │   └── 📁 test/
│   │   │       └── 📁 java/
│   │   │           └── 📁 com/
│   │   │               └── 📁 example/
│   │   │                   └── 📁 categories_screen/
│   │   │                       └── ☕ ExampleUnitTest.java
│   │   ├── ⚙️ .gitignore
│   │   └── 📄 proguard-rules.pro
│   ├── 📁 quiz_question_screen/
│   │   ├── 📁 src/
│   │   │   ├── 📁 androidTest/
│   │   │   │   └── 📁 java/
│   │   │   │       └── 📁 com/
│   │   │   │           └── 📁 example/
│   │   │   │               └── 📁 quiz_question_screen/
│   │   │   │                   └── ☕ ExampleInstrumentedTest.java
│   │   │   ├── 📁 main/
│   │   │   │   ├── 📁 java/
│   │   │   │   │   └── 📁 com/
│   │   │   │   │       └── 📁 example/
│   │   │   │   │           └── 📁 quiz_question_screen/
│   │   │   │   │               └── ☕ MainActivity.java
│   │   │   │   ├── 📁 res/
│   │   │   │   │   ├── 📁 drawable/
│   │   │   │   │   │   ├── ⚙️ bg_op1.xml
│   │   │   │   │   │   ├── ⚙️ bg_op_true.xml
│   │   │   │   │   │   ├── ⚙️ bg_option.xml
│   │   │   │   │   │   ├── ⚙️ bg_true.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   │   └── ⚙️ ic_launcher_foreground.xml
│   │   │   │   │   ├── 📁 layout/
│   │   │   │   │   │   └── ⚙️ activity_main.xml
│   │   │   │   │   ├── 📁 mipmap-anydpi-v26/
│   │   │   │   │   │   ├── ⚙️ ic_launcher.xml
│   │   │   │   │   │   └── ⚙️ ic_launcher_round.xml
│   │   │   │   │   ├── 📁 mipmap-hdpi/
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-mdpi/
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-xhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-xxhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-xxxhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 values/
│   │   │   │   │   │   ├── ⚙️ colors.xml
│   │   │   │   │   │   ├── ⚙️ strings.xml
│   │   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   │   └── 📁 values-night/
│   │   │   │   │       └── ⚙️ themes.xml
│   │   │   │   └── ⚙️ AndroidManifest.xml
│   │   │   └── 📁 test/
│   │   │       └── 📁 java/
│   │   │           └── 📁 com/
│   │   │               └── 📁 example/
│   │   │                   └── 📁 quiz_question_screen/
│   │   │                       └── ☕ ExampleUnitTest.java
│   │   ├── ⚙️ .gitignore
│   │   └── 📄 proguard-rules.pro
│   ├── 📁 results_screen/
│   │   ├── 📁 src/
│   │   │   ├── 📁 androidTest/
│   │   │   │   └── 📁 java/
│   │   │   │       └── 📁 com/
│   │   │   │           └── 📁 example/
│   │   │   │               └── 📁 results_screen/
│   │   │   │                   └── ☕ ExampleInstrumentedTest.java
│   │   │   ├── 📁 main/
│   │   │   │   ├── 📁 java/
│   │   │   │   │   └── 📁 com/
│   │   │   │   │       └── 📁 example/
│   │   │   │   │           └── 📁 results_screen/
│   │   │   │   │               └── ☕ MainActivity.java
│   │   │   │   ├── 📁 res/
│   │   │   │   │   ├── 📁 drawable/
│   │   │   │   │   │   ├── ⚙️ bg_cirle.xml
│   │   │   │   │   │   ├── ⚙️ bg_rd.xml
│   │   │   │   │   │   ├── ⚙️ bg_rd2.xml
│   │   │   │   │   │   ├── ⚙️ bg_rd3.xml
│   │   │   │   │   │   ├── ⚙️ bg_rd4.xml
│   │   │   │   │   │   ├── ⚙️ bg_rd5.xml
│   │   │   │   │   │   ├── ⚙️ btn_back.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher_foreground.xml
│   │   │   │   │   │   └── ⚙️ result_btn.xml
│   │   │   │   │   ├── 📁 layout/
│   │   │   │   │   │   └── ⚙️ activity_main.xml
│   │   │   │   │   ├── 📁 mipmap-anydpi-v26/
│   │   │   │   │   │   ├── ⚙️ ic_cup.xml
│   │   │   │   │   │   ├── ⚙️ ic_cup_round.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher.xml
│   │   │   │   │   │   └── ⚙️ ic_launcher_round.xml
│   │   │   │   │   ├── 📁 mipmap-hdpi/
│   │   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-mdpi/
│   │   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-xhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-xxhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 mipmap-xxxhdpi/
│   │   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 📁 values/
│   │   │   │   │   │   ├── ⚙️ colors.xml
│   │   │   │   │   │   ├── ⚙️ ic_cup_background.xml
│   │   │   │   │   │   ├── ⚙️ strings.xml
│   │   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   │   └── 📁 values-night/
│   │   │   │   │       └── ⚙️ themes.xml
│   │   │   │   ├── ⚙️ AndroidManifest.xml
│   │   │   │   └── 🖼️ ic_cup-playstore.png
│   │   │   └── 📁 test/
│   │   │       └── 📁 java/
│   │   │           └── 📁 com/
│   │   │               └── 📁 example/
│   │   │                   └── 📁 results_screen/
│   │   │                       └── ☕ ExampleUnitTest.java
│   │   ├── ⚙️ .gitignore
│   │   └── 📄 proguard-rules.pro
│   ├── 📁 src/
│   │   ├── 📁 androidTest/
│   │   │   └── 📁 java/
│   │   │       └── 📁 com/
│   │   │           └── 📁 example/
│   │   │               └── 📁 quizzapp/
│   │   │                   └── ☕ ExampleInstrumentedTest.java
│   │   ├── 📁 main/
│   │   │   ├── 📁 java/
│   │   │   │   ├── 📁 API/
│   │   │   │   │   ├── ☕ ApiClient.java
│   │   │   │   │   └── ☕ ApiService.java
│   │   │   │   ├── 📁 Auth/
│   │   │   │   │   └── ☕ AuthToken.java
│   │   │   │   ├── 📁 Model_account/
│   │   │   │   │   ├── ☕ AccountResponse.java
│   │   │   │   │   ├── ☕ Role.java
│   │   │   │   │   └── ☕ User.java
│   │   │   │   ├── 📁 com/
│   │   │   │   │   └── 📁 example/
│   │   │   │   │       └── 📁 quizzapp/
│   │   │   │   │           ├── ☕ CustomMenu.java
│   │   │   │   │           ├── ☕ LB_Adapter.java
│   │   │   │   │           ├── ☕ LB_items.java
│   │   │   │   │           ├── ☕ MainActivity.java
│   │   │   │   │           ├── ☕ QuizzQuestion.java
│   │   │   │   │           ├── ☕ Quizz_Adapter.java
│   │   │   │   │           ├── ☕ Quizz_items.java
│   │   │   │   │           ├── ☕ Results_screen.java
│   │   │   │   │           ├── ☕ categories_Screen.java
│   │   │   │   │           ├── ☕ leaderboardScreen.java
│   │   │   │   │           ├── ☕ login.java
│   │   │   │   │           └── ☕ signUp.java
│   │   │   │   ├── 📁 model_SignUp/
│   │   │   │   │   ├── ☕ RequestSignUp.java
│   │   │   │   │   └── ☕ Respone_SignUp.java
│   │   │   │   ├── 📁 model_User/
│   │   │   │   │   ├── ☕ User.java
│   │   │   │   │   └── ☕ UserResponse.java
│   │   │   │   ├── 📁 model_login/
│   │   │   │   │   ├── ☕ Request.java
│   │   │   │   │   └── ☕ Respone.java
│   │   │   │   └── 📁 model_result/
│   │   │   │       └── ☕ Result.java
│   │   │   ├── 📁 res/
│   │   │   │   ├── 📁 custom/
│   │   │   │   ├── 📁 drawable/
│   │   │   │   │   ├── 📁 drawable/
│   │   │   │   │   │   ├── ⚙️ bg_choose.xml
│   │   │   │   │   │   ├── ⚙️ bg_ct.xml
│   │   │   │   │   │   ├── ⚙️ bg_his.xml
│   │   │   │   │   │   ├── ⚙️ bg_monhoc.xml
│   │   │   │   │   │   ├── ⚙️ bg_op.xml
│   │   │   │   │   │   ├── ⚙️ bg_op2.xml
│   │   │   │   │   │   ├── ⚙️ bg_op3.xml
│   │   │   │   │   │   ├── ⚙️ bg_op4.xml
│   │   │   │   │   │   ├── ⚙️ bg_sp.xml
│   │   │   │   │   │   ├── ⚙️ border_rd.xml
│   │   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   │   └── ⚙️ ic_launcher_foreground.xml
│   │   │   │   │   ├── ⚙️ backward_solid_full.xml
│   │   │   │   │   ├── ⚙️ bars_solid_full.xml
│   │   │   │   │   ├── ⚙️ bg_btn.xml
│   │   │   │   │   ├── ⚙️ bg_btn_login.xml
│   │   │   │   │   ├── ⚙️ bg_btn_menu.xml
│   │   │   │   │   ├── ⚙️ bg_choose.xml
│   │   │   │   │   ├── ⚙️ bg_cirle.xml
│   │   │   │   │   ├── ⚙️ bg_ct.xml
│   │   │   │   │   ├── ⚙️ bg_header.xml
│   │   │   │   │   ├── ⚙️ bg_his.xml
│   │   │   │   │   ├── ⚙️ bg_itemquizz.xml
│   │   │   │   │   ├── ⚙️ bg_leaderboard1.xml
│   │   │   │   │   ├── ⚙️ bg_leaderboard2.xml
│   │   │   │   │   ├── ⚙️ bg_leaderboard3.xml
│   │   │   │   │   ├── ⚙️ bg_list.xml
│   │   │   │   │   ├── ⚙️ bg_monhoc.xml
│   │   │   │   │   ├── ⚙️ bg_op.xml
│   │   │   │   │   ├── ⚙️ bg_op1.xml
│   │   │   │   │   ├── ⚙️ bg_op2.xml
│   │   │   │   │   ├── ⚙️ bg_op3.xml
│   │   │   │   │   ├── ⚙️ bg_op4.xml
│   │   │   │   │   ├── ⚙️ bg_op_true.xml
│   │   │   │   │   ├── ⚙️ bg_option.xml
│   │   │   │   │   ├── ⚙️ bg_popup.xml
│   │   │   │   │   ├── ⚙️ bg_rd3.xml
│   │   │   │   │   ├── ⚙️ bg_rd4.xml
│   │   │   │   │   ├── ⚙️ bg_rd5.xml
│   │   │   │   │   ├── ⚙️ bg_sp.xml
│   │   │   │   │   ├── ⚙️ bg_true.xml
│   │   │   │   │   ├── ⚙️ bg_user.xml
│   │   │   │   │   ├── ⚙️ bg_user01.xml
│   │   │   │   │   ├── ⚙️ border_rd.xml
│   │   │   │   │   ├── ⚙️ btn_back.xml
│   │   │   │   │   ├── ⚙️ btn_submit.xml
│   │   │   │   │   ├── ⚙️ chevron_left_solid_full.xml
│   │   │   │   │   ├── ⚙️ circle_main.xml
│   │   │   │   │   ├── ⚙️ circle_question_regular_full.xml
│   │   │   │   │   ├── ⚙️ circle_xmark_solid_full.xml
│   │   │   │   │   ├── ⚙️ cirle.xml
│   │   │   │   │   ├── ⚙️ color_body.xml
│   │   │   │   │   ├── ⚙️ eye_solid_full.xml
│   │   │   │   │   ├── ⚙️ house_regular_full.xml
│   │   │   │   │   ├── ⚙️ ic_clock_background.xml
│   │   │   │   │   ├── ⚙️ ic_clock_foreground.xml
│   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   ├── ⚙️ ic_launcher_foreground.xml
│   │   │   │   │   ├── ⚙️ outline_accessibility_on.xml
│   │   │   │   │   ├── ⚙️ outline_accessible_off.xml
│   │   │   │   │   ├── ⚙️ outline_apps_24.xml
│   │   │   │   │   ├── ⚙️ outline_arrow_left_24.xml
│   │   │   │   │   ├── ⚙️ outline_grid_view_24.xml
│   │   │   │   │   ├── 🖼️ phaohoa.png
│   │   │   │   │   ├── ⚙️ ranking_star_solid_full.xml
│   │   │   │   │   ├── ⚙️ result_btn.xml
│   │   │   │   │   ├── ⚙️ square_caret_left_solid_full.xml
│   │   │   │   │   ├── ⚙️ square_poll_vertical_solid_full.xml
│   │   │   │   │   └── ⚙️ tag_solid_full.xml
│   │   │   │   ├── 📁 layout/
│   │   │   │   │   ├── ⚙️ activity_categories_screen.xml
│   │   │   │   │   ├── ⚙️ activity_leaderboard_screen.xml
│   │   │   │   │   ├── ⚙️ activity_login.xml
│   │   │   │   │   ├── ⚙️ activity_main.xml
│   │   │   │   │   ├── ⚙️ activity_quizz_question.xml
│   │   │   │   │   ├── ⚙️ activity_results_screen.xml
│   │   │   │   │   ├── ⚙️ activity_sign_up.xml
│   │   │   │   │   ├── ⚙️ back_button.xml
│   │   │   │   │   ├── ⚙️ custom_menu.xml
│   │   │   │   │   ├── ⚙️ item_leaderboard.xml
│   │   │   │   │   ├── ⚙️ item_quizz.xml
│   │   │   │   │   └── ⚙️ menu_button.xml
│   │   │   │   ├── 📁 layout-w1240dp/
│   │   │   │   ├── 📁 layout-w936dp/
│   │   │   │   ├── 📁 menu/
│   │   │   │   │   └── ⚙️ menu_main.xml
│   │   │   │   ├── 📁 mipmap-anydpi-v26/
│   │   │   │   │   ├── ⚙️ ic_ball.xml
│   │   │   │   │   ├── ⚙️ ic_ball_round.xml
│   │   │   │   │   ├── ⚙️ ic_book.xml
│   │   │   │   │   ├── ⚙️ ic_book_round.xml
│   │   │   │   │   ├── ⚙️ ic_clock.xml
│   │   │   │   │   ├── ⚙️ ic_clock_round.xml
│   │   │   │   │   ├── ⚙️ ic_cup.xml
│   │   │   │   │   ├── ⚙️ ic_cup_round.xml
│   │   │   │   │   ├── ⚙️ ic_king.xml
│   │   │   │   │   ├── ⚙️ ic_king_round.xml
│   │   │   │   │   ├── ⚙️ ic_launcher.xml
│   │   │   │   │   ├── ⚙️ ic_launcher_round.xml
│   │   │   │   │   ├── ⚙️ ic_td.xml
│   │   │   │   │   ├── ⚙️ ic_td_round.xml
│   │   │   │   │   ├── ⚙️ ic_user.xml
│   │   │   │   │   └── ⚙️ ic_user_round.xml
│   │   │   │   ├── 📁 mipmap-hdpi/
│   │   │   │   │   ├── 🖼️ hoi.webp
│   │   │   │   │   ├── 🖼️ hoi_1.webp
│   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   ├── 🖼️ ic_clock.webp
│   │   │   │   │   ├── 🖼️ ic_clock_round.webp
│   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   ├── 🖼️ ic_diamond.webp
│   │   │   │   │   ├── 🖼️ ic_king.webp
│   │   │   │   │   ├── 🖼️ ic_king_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_king_round.webp
│   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   ├── 🖼️ ic_user.webp
│   │   │   │   │   ├── 🖼️ ic_user_foreground.webp
│   │   │   │   │   └── 🖼️ ic_user_round.webp
│   │   │   │   ├── 📁 mipmap-mdpi/
│   │   │   │   │   ├── 🖼️ hoi.webp
│   │   │   │   │   ├── 🖼️ hoi_1.webp
│   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   ├── 🖼️ ic_clock.webp
│   │   │   │   │   ├── 🖼️ ic_clock_round.webp
│   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   ├── 🖼️ ic_diamond.webp
│   │   │   │   │   ├── 🖼️ ic_king.webp
│   │   │   │   │   ├── 🖼️ ic_king_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_king_round.webp
│   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   ├── 🖼️ ic_user.webp
│   │   │   │   │   ├── 🖼️ ic_user_foreground.webp
│   │   │   │   │   └── 🖼️ ic_user_round.webp
│   │   │   │   ├── 📁 mipmap-xhdpi/
│   │   │   │   │   ├── 🖼️ hoi.webp
│   │   │   │   │   ├── 🖼️ hoi_1.webp
│   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   ├── 🖼️ ic_clock.webp
│   │   │   │   │   ├── 🖼️ ic_clock_round.webp
│   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   ├── 🖼️ ic_diamond.webp
│   │   │   │   │   ├── 🖼️ ic_king.webp
│   │   │   │   │   ├── 🖼️ ic_king_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_king_round.webp
│   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   ├── 🖼️ ic_user.webp
│   │   │   │   │   ├── 🖼️ ic_user_foreground.webp
│   │   │   │   │   └── 🖼️ ic_user_round.webp
│   │   │   │   ├── 📁 mipmap-xxhdpi/
│   │   │   │   │   ├── 🖼️ hoi.webp
│   │   │   │   │   ├── 🖼️ hoi_1.webp
│   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   ├── 🖼️ ic_clock.webp
│   │   │   │   │   ├── 🖼️ ic_clock_round.webp
│   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   ├── 🖼️ ic_diamond.webp
│   │   │   │   │   ├── 🖼️ ic_king.webp
│   │   │   │   │   ├── 🖼️ ic_king_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_king_round.webp
│   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   ├── 🖼️ ic_user.webp
│   │   │   │   │   ├── 🖼️ ic_user_foreground.webp
│   │   │   │   │   └── 🖼️ ic_user_round.webp
│   │   │   │   ├── 📁 mipmap-xxxhdpi/
│   │   │   │   │   ├── 🖼️ hoi.webp
│   │   │   │   │   ├── 🖼️ hoi_1.webp
│   │   │   │   │   ├── 🖼️ ic_ball.webp
│   │   │   │   │   ├── 🖼️ ic_ball_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_ball_round.webp
│   │   │   │   │   ├── 🖼️ ic_book.webp
│   │   │   │   │   ├── 🖼️ ic_book_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_book_round.webp
│   │   │   │   │   ├── 🖼️ ic_clock.webp
│   │   │   │   │   ├── 🖼️ ic_clock_round.webp
│   │   │   │   │   ├── 🖼️ ic_cup.webp
│   │   │   │   │   ├── 🖼️ ic_cup_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_cup_round.webp
│   │   │   │   │   ├── 🖼️ ic_diamond.webp
│   │   │   │   │   ├── 🖼️ ic_king.webp
│   │   │   │   │   ├── 🖼️ ic_king_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_king_round.webp
│   │   │   │   │   ├── 🖼️ ic_kinh_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   ├── 🖼️ ic_launcher_round.webp
│   │   │   │   │   ├── 🖼️ ic_td.webp
│   │   │   │   │   ├── 🖼️ ic_td_foreground.webp
│   │   │   │   │   ├── 🖼️ ic_td_round.webp
│   │   │   │   │   ├── 🖼️ ic_user.webp
│   │   │   │   │   ├── 🖼️ ic_user_foreground.webp
│   │   │   │   │   └── 🖼️ ic_user_round.webp
│   │   │   │   ├── 📁 values/
│   │   │   │   │   ├── ⚙️ CircleStyle.xml
│   │   │   │   │   ├── ⚙️ colors.xml
│   │   │   │   │   ├── ⚙️ diamond.xml
│   │   │   │   │   ├── ⚙️ dimens.xml
│   │   │   │   │   ├── ⚙️ ic_ball_background.xml
│   │   │   │   │   ├── ⚙️ ic_book_background.xml
│   │   │   │   │   ├── ⚙️ ic_cup_background.xml
│   │   │   │   │   ├── ⚙️ ic_king_background.xml
│   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   ├── ⚙️ ic_td_background.xml
│   │   │   │   │   ├── ⚙️ ic_user_background.xml
│   │   │   │   │   ├── ⚙️ strings.xml
│   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   ├── 📁 values-land/
│   │   │   │   │   └── ⚙️ dimens.xml
│   │   │   │   ├── 📁 values-night/
│   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   ├── 📁 values-w1240dp/
│   │   │   │   │   └── ⚙️ dimens.xml
│   │   │   │   ├── 📁 values-w600dp/
│   │   │   │   │   └── ⚙️ dimens.xml
│   │   │   │   └── 📁 xml/
│   │   │   │       ├── ⚙️ backup_rules.xml
│   │   │   │       ├── ⚙️ data_extraction_rules.xml
│   │   │   │       └── ⚙️ network_security_config.xml
│   │   │   ├── ⚙️ AndroidManifest.xml
│   │   │   ├── 🖼️ ic_ball-playstore.png
│   │   │   ├── 🖼️ ic_book-playstore.png
│   │   │   ├── 🖼️ ic_clock-playstore.png
│   │   │   ├── 🖼️ ic_cup-playstore.png
│   │   │   ├── 🖼️ ic_king-playstore.png
│   │   │   ├── 🖼️ ic_launcher-playstore.png
│   │   │   ├── 🖼️ ic_td-playstore.png
│   │   │   └── 🖼️ ic_user-playstore.png
│   │   └── 📁 test/
│   │       └── 📁 java/
│   │           └── 📁 com/
│   │               └── 📁 example/
│   │                   └── 📁 quizzapp/
│   │                       └── ☕ ExampleUnitTest.java
│   ├── ⚙️ .gitignore
│   └── 📄 proguard-rules.pro
├── 📁 gradle/
│   ├── 📁 wrapper/
│   │   ├── 📄 gradle-wrapper.jar
│   │   └── 📄 gradle-wrapper.properties
│   └── ⚙️ libs.versions.toml
├── ⚙️ .gitignore
├── 📝 README.md
├── 📄 gradle.properties
├── 📄 gradlew
├── 📄 gradlew.bat
└── 📄 settings.gradle



```
### Kiến trúc Modular
Dự án sử dụng kiến trúc **multi-module** để tách biệt các tính năng:
- **app**: Mô-đun chính chứa logic ứng dụng cốt lõi
- **categories_screen**: Mô-đun tính năng cho hiển thị danh mục
- **quiz_question_screen**: Mô-đun tính năng cho câu hỏi quiz
- **results_screen**: Mô-đun tính năng cho hiển thị kết quả


## 🔧 Công nghệ được sử dụng

### Framework & Thư viện chính
| Thành phần | Phiên bản | Mục đích |
|-----------|---------|---------|
| **AndroidX AppCompat** | 1.7.1 | Tương thích ngược với Android cũ hơn |
| **Material Design** | 1.13.0 | Thành phần giao diện Material |
| **ConstraintLayout** | 2.2.1 | Bố cục linh hoạt cho giao diện |
| **Retrofit** | 2.9.0 | REST API client cho gọi mạng |
| **OkHttp** | 4.11.0 | HTTP client và logging |
| **Gson** | (từ Retrofit) | JSON serialization/deserialization |
| **Lifecycle** | 2.6.1 | Quản lý vòng đời component |
| **LiveData** | 2.6.1 | Observable data holder |

### Testing
| Thành phần | Phiên bản |
|-----------|---------|
| **JUnit** | 4.13.2 |
| **Espresso** | 3.7.0 |
| **AndroidX Test** | 1.3.0 |

### Build & Toolchain
- **Gradle AGP**: 8.12.0
- **Java Compatibility**: Java 11
- **Compile SDK**: Android 36
- **Min SDK**: Android 26 (API 26)
- **Target SDK**: Android 36

---

## 🚀 Quy trình phát triển

### Chuẩn bị môi trường phát triển
1. Cài đặt Android Studio phiên bản mới nhất
2. Cài đặt JDK 11+
3. Cấu hình Android SDK (API 26-36)

### Tạo nhánh phát triển
```bash
git checkout -b feature/tên-tính-năng
```

### Build & Test
```bash
# Build debug
./gradlew build

# Chạy kiểm tra
./gradlew test

# Chạy kiểm tra Android
./gradlew connectedAndroidTest
```

### Gửi Pull Request
1. Commit thay đổi của bạn
2. Push nhánh lên GitHub
3. Tạo Pull Request với mô tả chi tiết

---

## 📝 Cấu hình Retrofit/API

Ứng dụng sử dụng Retrofit để gọi API từ backend:

```java
// Retrofit instance được cấu hình với:
// - Base URL của API server
// - Gson converter cho JSON
// - OkHttp logging interceptor cho debug
```

**Cấu hình kết nối bảo mật**: Ứng dụng hỗ trợ lưu lưu thông tin nhạy cảm qua `network_security_config.xml`

---

## 🔒 Bảo mật

- ✅ **ProGuard Obfuscation**: Được bật cho build release
- ✅ **Network Security**: Cấu hình bảo mật mạng tùy chỉnh
- ✅ **INTERNET Permission**: Yêu cầu cấp phép để kết nối mạng
- ✅ **Backup Rules**: Quy tắc sao lưu dữ liệu được cấu hình

---

## 📊 Tính năng nâng cao

### Quản lý dữ liệu
- Sử dụng **LiveData** cho cập nhật giao diện phản ứng
- **ViewModel** cho quản lý trạng thái activity

### Điều hướng
- Chuyển động mượt mà giữa các màn hình
- Back stack quản lý tích hợp

### Hiệu suất
- Tối ưu hóa bộ đệm cho hình ảnh
- Lazy loading dữ liệu

---

## 🐛 Gỡ lỗi

### Logging
Để bật logging chi tiết:
```kotlin
// Thêm HttpLoggingInterceptor vào OkHttp client
val logging = HttpLoggingInterceptor()
logging.level = HttpLoggingInterceptor.Level.BODY
```

### Common Issues
| Vấn đề | Giải pháp |
|--------|---------|
| Gradle sync thất bại | Hãy thử `File > Invalidate Caches` |
| API không phản hồi | Kiểm tra kết nối Internet và cấu hình URL |
| Crash khi khởi động | Kiểm tra logcat và quyền trong manifest |

---

## 📈 Kế hoạch phát triển tương lai

- [ ] Thêm animation nâng cao
- [ ] Hỗ trợ offline mode
- [ ] Cải thiện hiệu suất
- [ ] Thêm tính năng social sharing
- [ ] Support cho multiple languages
- [ ] Dark mode support
- [ ] Push notifications

---

## 👥 Đóng góp

Chúng tôi rất hoan nghênh những đóng góp! Để đóng góp:

1. Fork dự án
2. Tạo nhánh tính năng (`git checkout -b feature/AmazingFeature`)
3. Commit thay đổi (`git commit -m 'Add some AmazingFeature'`)
4. Push nhánh (`git push origin feature/AmazingFeature`)
5. Mở Pull Request

---

## 📄 Giấy phép

Dự án này được cấp phép dưới giấy phép MIT - xem file [LICENSE](LICENSE) để biết chi tiết.

---

## 📞 Hỗ trợ & Liên hệ

- **GitHub**: [thai2862005/QuizzApp](https://github.com/thai2862005/QuizzApp)
- **Issues**: [Báo cáo lỗi hoặc yêu cầu tính năng](https://github.com/thai2862005/QuizzApp/issues)

---

## 🙏 Cảm ơn

Cảm ơn tất cả những người đã đóng góp cho dự án này!

---

<div align="center">

**Được xây dựng với ❤️ bằng Android Studio**

![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white)

</div>
