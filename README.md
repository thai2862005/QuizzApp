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
QuizzApp/
├── app/                                # Mô-đun chính của ứng dụng
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/quizzapp/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── LoginActivity.java
│   │   │   │   ├── categories_Screen.java
│   │   │   │   ├── QuizzQuestion.java
│   │   │   │   ├── Results_screen.java
│   │   │   │   ├── leaderboardScreen.java
│   │   │   │   └── MenuActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/            # Tệp XML của giao diện
│   │   │   │   ├── drawable/         # Hình ảnh và tài nguyên
│   │   │   │   ├── values/           # Chuỗi, màu sắc, kiểu dáng
│   │   │   │   └── menu/             # Tệp menu
│   │   │   └── AndroidManifest.xml   # Cấu hình ứng dụng
│   │   ├── test/                      # Bài kiểm tra đơn vị
│   │   └── androidTest/               # Bài kiểm tra Android
│   ├── categories_screen/             # Mô-đun tính năng: Danh mục
│   ├── quiz_question_screen/          # Mô-đun tính năng: Câu hỏi quiz
│   ├── results_screen/                # Mô-đun tính năng: Kết quả
│   ├── build.gradle                   # Cấu hình Gradle cho ứng dụng
│   └── proguard-rules.pro            # Quy tắc ProGuard cho tối ưu hóa
├── gradle/
│   ├── libs.versions.toml             # Quản lý phiên bản phụ thuộc
│   └── wrapper/
├── build.gradle                       # Cấu hình Gradle chính
├── settings.gradle                    # Cấu hình dự án đa mô-đun
├── gradlew                            # Gradle wrapper (Linux/Mac)
├── gradlew.bat                        # Gradle wrapper (Windows)
└── README.md                          # Tài liệu này
```

### Kiến trúc Modular
Dự án sử dụng kiến trúc **multi-module** để tách biệt các tính năng:
- **app**: Mô-đun chính chứa logic ứng dụng cốt lõi
- **categories_screen**: Mô-đun tính năng cho hiển thị danh mục
- **quiz_question_screen**: Mô-đun tính năng cho câu hỏi quiz
- **results_screen**: Mô-đun tính năng cho hiển thị kết quả

---

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
