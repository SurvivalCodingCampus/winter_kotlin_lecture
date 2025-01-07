import day14.TodoUserDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class UserDataSourceImplTest {

 @Test
 fun checkUsers() = runBlocking {
  val userDataSourceImpl = TodoUserDataSourceImpl()
  val users = userDataSourceImpl.getUsers()
  val firstUser = users[0]

  assertEquals(1, firstUser.id)
  assertEquals("Leanne Graham", firstUser.name)
  assertEquals("Bret", firstUser.username)
  assertEquals("Sincere@april.biz", firstUser.email)

  val address = firstUser.address
  assertEquals("Kulas Light", address.street)
  assertEquals("Apt. 556", address.suite)
  assertEquals("Gwenborough", address.city)
  assertEquals("92998-3874", address.zipcode)

  val geo = address.geo
  assertEquals("-37.3159", geo.lat)
  assertEquals("81.1496", geo.lng)
 }
}
