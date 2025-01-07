package day15.repository.user

import day15.data_source.user.MockUserDataSourceImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals


class UserRepositoryImplTest {
  private val userRepositoryImpl = UserRepositoryImpl(MockUserDataSourceImpl())

  @Test
  fun `전체 user 받아온후 데이터 size 확인`() = runBlocking {
    val result = userRepositoryImpl.getUsers()

    assertEquals(10, result.size)
  }

 @Test
 fun `전체 user를 받아온 후에 이름순으로 정렬 후 사이즈가 10개가 되는지 확인`() = runBlocking {
   val originUsers = userRepositoryImpl.getUsers()

   val tenUsers = userRepositoryImpl.getUsersTop10ByUserName()

   // 사이즈 10개 확인
   assertEquals(10, tenUsers.size)

   // 원본데이터에서 이름순 정렬후 10개를 가져왔을때 메소드에서 가져온거랑 동일한지 확인
   assertEquals(originUsers.sortedBy { it.name }.take(10), tenUsers)
 }
}