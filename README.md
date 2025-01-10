# Kotlin Study

## 📁 폴더 구조
```
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           ├── day1/
│           │   ├── Person.kt        // 클래스 작성
│           │   └── Solution.kt      // 실습 문제 풀이
│           └── day2/
│               └── Variable.kt      // 변수 관련 실습
│
├── docs/
│   ├── daily/                 // 일일 학습 기록
│   │   ├── 2024-01-15.md
│   │   └── 2024-01-16.md
│   │
│   └── topics/               // 주제별 심화 학습 기록
│       ├── generics.md
│       └── lambda.md
│
├── build.gradle.kts
└── README.md
```


## 개인 학습 현황

### 📝 학습 기록
- [2024-12-16](docs/daily/2024-12-16.md) - OT & Git&Github 기초
- [2024-12-17](docs/daily/2024-12-17.md) - Git협업 & Kotlin 기초
- [2024-12-18](docs/daily/2024-12-18.md) - 클래스 인스턴스
- [2024-12-19](docs/daily/2024-12-19.md) - 클래스, companion
- [2024-12-20](docs/daily/2024-12-20.md) - 캡슐화, 컬렉션 
- [2024-12-23](docs/daily/2024-12-23.md) - 상속
- [2024-12-24](docs/daily/2024-12-24.md) - 추상클래스,인터페이스
- [2024-12-30](docs/daily/2024-12-30.md) - 제네릭, 열거형, 문자열 조작
- [2024-12-31](docs/daily/2024-12-31.md) - 예외 처리, 파일 조작, 여러가지 데이터형식
- [2025-01-02](docs/daily/2025-01-02.md) - 디버깅, 람다식과 함수
- [2025-01-03](docs/daily/2025-01-03.md) - 비동기 프로그래밍
- [2025-01-06](docs/daily/2025-01-06.md) - 데이터소스
- [2025-01-07](docs/daily/2025-01-07.md) - Test이론, Model Class, Repository 개념
- [2025-01-08](docs/daily/2025-01-08.md) - 네트워크 통신
- [2025-01-09](docs/daily/2025-01-09.md) - DTO, Mapper
- [2025-01-10](docs/daily/2025-01-10.md) - Result패턴
- 
### 💻 작성 코드
- Day 2
  - [Basic.kt](src/main/kotlin/day02/Basic.kt)
- Day 3
  - [Hero.kt](src/main/kotlin/day03/Hero.kt)
  - [HeroTest.kt](src/test/kotlin/day03/HeroTest.kt)
  - [Cleric.kt](src/main/kotlin/day03/Cleric.kt)
  - [ClericTest.kt](src/test/kotlin/day03/ClericTest.kt)
- Day 5
  - [Person.kt](src/main/kotlin/day05/Person.kt)
  - [PersonTest.kt](src/test/kotlin/day05/PersonTest.kt)
  - [Wand.kt](src/main/kotlin/day05/Wand.kt)
  - [WandTest.kt](src/test/kotlin/day05/WandTest.kt)
  - [Wizard.kt](src/main/kotlin/day05/Wizard.kt)
  - [WizardTest.kt](src/test/kotlin/day05/WizardTest.kt)
- Day 6
  - [GreatWizard.kt](src/main/kotlin/day06/GreatWizard.kt)
  - [GreatWizardTest.kt](src/test/kotlin/day06/GreatWizardTest.kt)
  - [PoisonSlime.kt](src/main/kotlin/day06/PoisonSlime.kt)
  - [PoisonSlimeTest.kt](src/test/kotlin/day06/PoisonSlimeTest.kt)
- Day 7
  - [Person.kt](src/main/kotlin/day07/Person.kt)
  - [PersonTest.kt](src/test/kotlin/day07/PersonTest.kt)
  - [Game.puml](src/main/kotlin/day07/Game.puml)
  - [Asset.puml](src/main/kotlin/day07/Asset.puml)
  - [Asset.kt](src/main/kotlin/day07/Asset.kt)
  - [Book.kt](src/main/kotlin/day07/Book.kt)
  - [Computer.kt](src/main/kotlin/day07/Computer.kt)
  - [IntangibleAsset.kt](src/main/kotlin/day07/IntangibleAsset.kt)
  - [Patent.kt](src/main/kotlin/day07/Patent.kt)
  - [TangibleAsset.kt](src/main/kotlin/day07/TangibleAsset.kt)
  - [Thing.kt](src/main/kotlin/day07/Thing.kt)
- Day 8
  - [A.kt](src/main/kotlin/day08/A.kt)
- Day 10
  - [StrongBox.kt](src/main/kotlin/day10/StrongBox.kt)
  - [StrongBoxTest.kt](src/test/kotlin/day10/StrongBoxTest.kt)
  - [Word.kt](src/main/kotlin/day10/Word.kt)
  - [WordTest.kt](src/test/kotlin/day10/WordTest.kt)
- Day 11
  - [FileOperations.kt](src/main/kotlin/day11/FileOperations.kt)
  - [DefaultFileOperations.kt](src/main/kotlin/day11/DefaultFileOperations.kt)
  - [DefaultFileOperationsTest.kt](src/test/kotlin/day11/DefaultFileOperationsTest.kt)
  - [Employee.kt](src/main/kotlin/day11/Employee.kt)
  - [RuntimeError.kt](src/main/kotlin/day11/RuntimeError.kt)
  - [User.kt](src/main/kotlin/day11/User.kt)
- Day 12
  - [CallBackExam.kt](src/main/kotlin/day12/CallBackExam.kt)
  - [CollectionChartDataList.kt](src/main/kotlin/day12/CollectionChartDataList.kt)
  - [LambdaExam.kt](src/main/kotlin/day12/LambdaExam.kt)
  - [Transaction.kt](src/main/kotlin/day12/Transaction.kt)
- Day 13
  - [Async.kt](src/main/kotlin/day13/Async.kt)
  - [Asynchronous.kt](src/main/kotlin/day13/Asynchronous.kt)
  - [Asynchronous2.kt](src/main/kotlin/day13/Asynchronous2.kt)
  - [Bird.kt](src/main/kotlin/day13/Bird.kt)
  - [CoroutineExam.kt](src/main/kotlin/day13/CoroutineExam.kt)
  - [DispatchersExam.kt](src/main/kotlin/day13/DispatchersExam.kt)
  - [MovieExam.kt](src/main/kotlin/day13/MovieExam.kt)
  - [MovieExamTest.kt](src/test/kotlin/day13/MovieExamTest.kt)
  - [WeatherCallback.kt](src/main/kotlin/day13/WeatherCallback.kt)
  - [WeatherCoroutine.kt](src/main/kotlin/day13/WeatherCoroutine.kt)
  - [WeatherLegacy.kt](src/main/kotlin/day13/WeatherLegacy.kt)
- Day 14
  - [StockDataSource.kt](src/main/kotlin/day14/StockDataSource.kt)
  - [StockDataSourceTest.kt](src/test/kotlin/day14/StockDataSourceImplTest.kt)
  - [TodoDataSource.kt](src/main/kotlin/day14/TodoDataSource.kt)
  - [TodoDataSourceTest.kt](src/test/kotlin/day14/TodoDataSourceImplTest.kt)
  - [UserDataSource.kt](src/main/kotlin/day14/UserDataSource.kt)
  - [UserDataSourceTest.kt](src/test/kotlin/day14/UserDataSourceImplTest.kt)
- Day 15
  - [AlbumDataSource.kt](src/main/kotlin/day15/data_source/AlbumDataSource.kt)
  - [CommentDataSource.kt](src/main/kotlin/day15/data_source/CommentDataSource.kt)
  - [MockAlbumDatasourceImpl.kt](src/main/kotlin/day15/data_source/MockAlbumDatasourceImpl.kt)
  - [MockCommentDatasourceImpl.kt](src/main/kotlin/day15/data_source/MockCommentDatasourceImpl.kt)
  - [MockPhotoDatasourceImpl.kt](src/main/kotlin/day15/data_source/MockPhotoDatasourceImpl.kt)
  - [MockPostDatasourceImpl.kt](src/main/kotlin/day15/data_source/MockPostDatasourceImpl.kt)
  - [MockTodoDatasourceImpl.kt](src/main/kotlin/day15/data_source/MockTodoDatasourceImpl.kt)
  - [MockUserDatasourceImpl.kt](src/main/kotlin/day15/data_source/MockUserDatasourceImpl.kt)
  - [PhotoDataSource.kt](src/main/kotlin/day15/data_source/PhotoDataSource.kt)
  - [PostDataSource.kt](src/main/kotlin/day15/data_source/PostDataSource.kt)
  - [TodoDataSource.kt](src/main/kotlin/day15/data_source/TodoDataSource.kt)
  - [UserDataSource.kt](src/main/kotlin/day15/data_source/UserDataSource.kt)
  - [Album.kt](src/main/kotlin/day15/model/Album.kt)
  - [Comment.kt](src/main/kotlin/day15/model/Comment.kt)
  - [Photo.kt](src/main/kotlin/day15/model/Photo.kt)
  - [Post.kt](src/main/kotlin/day15/model/Post.kt)
  - [Todo.kt](src/main/kotlin/day15/model/Todo.kt)
  - [User.kt](src/main/kotlin/day15/model/User.kt)
  - [AlbumRepository.kt](src/main/kotlin/day15/repository/AlbumRepository.kt)
  - [AlbumRepositoryImpl.kt](src/main/kotlin/day15/repository/AlbumRepositoryImpl.kt)
  - [CommentRepository.kt](src/main/kotlin/day15/repository/CommentRepository.kt)
  - [CommentRepositoryImpl.kt](src/main/kotlin/day15/repository/CommentRepositoryImpl.kt)
  - [PhotoRepository.kt](src/main/kotlin/day15/repository/PhotoRepository.kt)
  - [PhotoRepositoryImpl.kt](src/main/kotlin/day15/repository/PhotoRepositoryImpl.kt)
  - [PostRepository.kt](src/main/kotlin/day15/repository/PostRepository.kt)
  - [PostRepositoryImpl.kt](src/main/kotlin/day15/repository/PostRepositoryImpl.kt)
  - [TodoRepository.kt](src/main/kotlin/day15/repository/TodoRepository.kt)
  - [TodoRepositoryImpl.kt](src/main/kotlin/day15/repository/TodoRepositoryImpl.kt)
  - [UserRepository.kt](src/main/kotlin/day15/repository/UserRepository.kt)
  - [UserRepositoryImpl.kt](src/main/kotlin/day15/repository/UserRepositoryImpl.kt)
  - [AlbumRepositoryImplTest.kt](src/test/kotlin/day15/repository/AlbumRepositoryImplTest.kt)
  - [CommentRepositoryImplTest.kt](src/test/kotlin/day15/repository/CommentRepositoryImplTest.kt)
  - [PhotoRepositoryImplTest.kt](src/test/kotlin/day15/repository/PhotoRepositoryImplTest.kt)
  - [PostRepositoryImplTest.kt](src/test/kotlin/day15/repository/PostRepositoryImplTest.kt)
  - [TodoRepositoryImplTest.kt](src/test/kotlin/day15/repository/TodoRepositoryImplTest.kt)
  - [UserRepositoryImplTest.kt](src/test/kotlin/day15/repository/UserRepositoryImplTest.kt)
- Day 16
  - [HttpDemo.kt](src/main/kotlin/day16/HttpDemo.kt)
  - [ImageDataSource.kt](src/main/kotlin/day16/)
  - [MockImageDataSource.kt](src/main/kotlin/day16/data_source/MockImageDataSource.kt)
  - [MockMovieDataSource.kt](src/main/kotlin/day16/data_source/MockMovieDataSource.kt)
  - [MovieDataSource.kt](src/main/kotlin/day16/data_source/MovieDataSource.kt)
  - [MovieDataSourceImpl.kt](src/main/kotlin/day16/data_source/MovieDataSourceImpl.kt)
  - [TodoDataSource.kt](src/main/kotlin/day16/data_source/TodoDataSource.kt)
  - [TodoDataSourceImpl.kt](src/main/kotlin/day16/data_source/TodoDataSourceImpl.kt)
  - [DownloadInfo.kt](src/main/kotlin/day16/model/DownloadInfo.kt)
  - [Movie.kt](src/main/kotlin/day16/model/Movie.kt)
  - [Todo.kt](src/main/kotlin/day16/model/Todo.kt)
  - [ImageRepository.kt](src/main/kotlin/day16/repository/ImageRepository.kt)
  - [ImageRepositoryImpl.kt](src/main/kotlin/day16/repository/ImageRepositoryImpl.kt)
  - [MovieRepository.kt](src/main/kotlin/day16/repository/MovieRepository.kt)
  - [MovieRepositoryImpl.kt](src/main/kotlin/day16/repository/MovieRepositoryImpl.kt)
  - [TodoRepository.kt](src/main/kotlin/day16/repository/TodoRepository.kt)
  - [TodoRepositoryImpl.kt](src/main/kotlin/day16/repository/TodoRepositoryImpl.kt)
  - [ImageRepositoryImplTest.kt](src/test/kotlin/day16/repository/ImageRepositoryImplTest.kt)
  - [MovieRepositoryImplTest.kt](src/test/kotlin/day16/repository/MovieRepositoryImplTest.kt)
  - [TodoRepositoryImplTest.kt](src/test/kotlin/day16/repository/TodoRepositoryImplTest.kt)
- Day 17
  - [MovieDataSource.kt](src/main/kotlin/day17/data_source/MovieDataSource.kt)
  - [MovieDataSourceImpl.kt](src/main/kotlin/day17/data_source/MovieDataSourceImpl.kt)
  - [PhotoDataSource.kt](src/main/kotlin/day17/data_source/PhotoDataSource.kt)
  - [PhotoDataSourceImpl.kt](src/main/kotlin/day17/data_source/PhotoDataSourceImpl.kt)
  - [StoreDataSource.kt](src/main/kotlin/day17/data_source/StoreDataSource.kt)
  - [StoreDataSourceImpl.kt](src/main/kotlin/day17/data_source/StoreDataSourceImpl.kt)
  - [MovieDto.kt](src/main/kotlin/day17/dto/MovieDto.kt)
  - [PhotoDto.kt](src/main/kotlin/day17/dto/PhotoDto.kt)
  - [StoreDto.kt](src/main/kotlin/day17/dto/StoreDto.kt)
  - [MovieMapper.kt](src/main/kotlin/day17/mapper/MovieMapper.kt)
  - [PhotoMapper.kt](src/main/kotlin/day17/mapper/PhotoMapper.kt)
  - [StoreMapper.kt](src/main/kotlin/day17/mapper/StoreMapper.kt)
  - [Movie.kt](src/main/kotlin/day17/model/Movie.kt)
  - [Photo.kt](src/main/kotlin/day17/model/Photo.kt)
  - [PhotoType.kt](src/main/kotlin/day17/model/PhotoType.kt)
  - [Store.kt](src/main/kotlin/day17/model/Store.kt)
  - [MovieRepository.kt](src/main/kotlin/day17/repository/MovieRepository.kt)
  - [MovieRepositoryImpl.kt](src/main/kotlin/day17/repository/MovieRepositoryImpl.kt)
  - [PhotoRepository.kt](src/main/kotlin/day17/repository/PhotoRepository.kt)
  - [PhotoRepositoryImpl.kt](src/main/kotlin/day17/repository/PhotoRepositoryImpl.kt)
  - [StoreRepository.kt](src/main/kotlin/day17/repository/StoreRepository.kt)
  - [StoreRepositoryImpl.kt](src/main/kotlin/day17/repository/StoreRepositoryImpl.kt)
  - [MovieRepositoryImplTest.kt](src/test/kotlin/day17/repository/MovieRepositoryImplTest.kt)
  - [PhotoRepositoryImplTest.kt](src/test/kotlin/day17/repository/PhotoRepositoryImplTest.kt)
  - [StoreRepositoryImplTest.kt](src/test/kotlin/day17/repository/StoreRepositoryImplTest.kt)
- Day 18
  - [PhotoDataSource.kt](src/main/kotlin/day18/data_source/PhotoDataSource.kt)
  - [PhotoDataSourceImpl.kt](src/main/kotlin/day18/data_source/PhotoDataSourceImpl.kt)
  - [PhotoDto.kt](src/main/kotlin/day18/dto/PhotoDto.kt)
  - [PhotoMapper.kt](src/main/kotlin/day18/mapper/PhotoMapper.kt)
  - [Photo.kt](src/main/kotlin/day18/model/Photo.kt)
  - [PhotoRepository.kt](src/main/kotlin/day18/repository/PhotoRepository.kt)
  - [PhotoRepositoryImpl.kt](src/main/kotlin/day18/repository/PhotoRepositoryImpl.kt)
  - [ApiConfig.kt](src/main/kotlin/day18/utils/ApiConfig.kt)
  - [Result.kt](src/main/kotlin/day18/utils/Result.kt)
  - [PhotoRepositoryImplTest](src/test/kotlin/day18/repository/PhotoRepositoryImplTest.kt)


### 📚 주제별 정리
- [Git&Github](docs/topics/Git&Github.md)
- [Kotlin 기본 문법](docs/topics/Git&Github.md)

### 🔍 참고 자료
- [Kotlin 공식 문서](https://kotlinlang.org/docs/home.html)
- [코틀린 스타일 가이드](https://kotlinlang.org/docs/coding-conventions.html)
