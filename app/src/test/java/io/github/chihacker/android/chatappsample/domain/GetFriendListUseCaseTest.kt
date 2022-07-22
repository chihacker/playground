package io.github.chihacker.android.chatappsample.domain

import com.google.common.truth.Truth.assertThat
import io.github.chihacker.android.chatappsample.data.FriendRepository
import io.github.chihacker.android.chatappsample.data.model.FriendModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
//WhiteBox TDD
class GetFriendListUseCaseTest {

    private lateinit var SUT: GetFriendListUseCase

    @Mock
    private lateinit var friendRepository: FriendRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = GetFriendListUseCase(friendRepository)
    }

    @Test
    fun `invoke 실행, , friendDto 리스트 리턴`() {
        val result = SUT.invoke()
        assertThat(result.friends).isNotEmpty()
    }

    @Test
    fun `invoke 실행, getFriend, getRecommend, getFavorite 데이터 받았을때, friendDto 에는 모든 데이터가 포함되어야 한다`() {

    }

    @Test
    fun `invoke 실행, getFriend, getRecommend, getFavorite 데이터 받았을때, friendDto 에는 각 데이터 매칭되는 타입 올바르게 들어간다`() {

    }

    @Test
    fun `invoke 실행, getFriend, getRecommend, getFavorite 중 1개 또는 2개가 실패했을 때, friendDto 에는 성공한 데이터만 추가된다`() {
        val mockList = listOf<FriendModel>(FriendModel("1","aaa","eeeeee"))
        Mockito.`when`(friendRepository.getFriendList()).thenReturn(mockList)
        Mockito.`when`(friendRepository.getFavoriteList()).thenThrow(Exception())
        Mockito.`when`(friendRepository.getRecommendList()).thenThrow(Exception())
        //파라미터에 무엇이 들어왔는지 체크, mock api 가 실행될 때 파라미터 타입도 정할수 있고
        // 어떤 함수가 몇번 실행되었는지 체크 가능
        // spy

        val result = SUT.invoke()

        assertThat(result.friends).hasSize(1)
        assertThat(result.friends[0].id).isEqualTo(mockList[0].id)
        assertThat(result.friends[0].name).isEqualTo(mockList[0].name)
        assertThat(result.friends[0].id).isEqualTo(mockList[0].profileUrl)
    }

    @Test
    fun `invoke 실행, getFriend, getRecommend, getFavorite 모두 실패했을 때, friendDto 빈리스트가 들어간다`() {

    }
}