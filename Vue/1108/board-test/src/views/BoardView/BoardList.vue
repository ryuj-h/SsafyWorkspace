<script setup>
import PageNavigation from "../../components/navigation/PageNavigation.vue";
import { RouterLink, useRouter } from "vue-router";
import { ref } from "vue";
import axios from "axios";

const router = useRouter();

const params = ref({
  key: "", //조건 검색 시 컬럼명
  word: "", //해당 컬럼에 일치하는 데이터
  pgno: 8, //조회할 페이지 번호
  spp: 20, //한번에 얻어올 게시글 개수
});

const totalPageCount = ref(0); //전체 페이지 개수

const list = ref([]);

const getBoardList = async () => {
  const url = "http://localhost/vue/board";

  const response = await axios.get(url, {
    params: params.value,
  });
  console.log("axios의 응답:", response);

  list.value = response.data.articles;
  totalPageCount.value = response.data.totalPageCount;
};

getBoardList();

const moveDetail = (articleNo) => {
  router.push({ name: "article-detail", params: { articleNo } });
};

const changePage = (pageNum) => {
  console.log("페이지 변경 , 페이지 번호:", pageNum);
  params.value.pgno = pageNum;
  getBoardList();
};

const selectedArticle = ref("");

const searchArticleMessage = ref("");

const searchArticle = () => {
  console.log("검색 : ", searchArticleMessage);
  getSearchArticleList();
};

const getSearchArticleList = async () => {
  const url = "http://localhost/vue/board";

  // params.value.key = null;
  // params.value.pgno = null;
  // params.value.spp = null;
  params.value.key = "subject"; //selectedArticle.value;
  params.value.word = searchArticleMessage.value;

  console.log(params);
  const response = await axios.get(url, {
    params: params.value,
  });
  console.log("axios의 응답:", response);

  list.value = response.data.articles;
  totalPageCount.value = response.data.totalPageCount;
};
</script>

<template>
  <div>
    <h1>게시판 목록</h1>
    <RouterLink :to="{ name: 'article-write' }">글쓰기</RouterLink>
    <table>
      <tr>
        <th>글 번호</th>
        <th>글 제목</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>작성자</th>
      </tr>
      <tr
        class="article-item"
        v-for="article in list"
        :key="article.articleNo"
        @click="moveDetail(article.articleNo)"
      >
        <td>{{ article.articleNo }}</td>
        <td>{{ article.subject }}</td>
        <td>{{ article.hit }}</td>
        <td>{{ article.registerTime }}</td>
        <td>{{ article.userId }}</td>
      </tr>
    </table>
    <PageNavigation
      v-on:change-page="changePage"
      :current-page="params.pgno"
      :total-page-count="totalPageCount"
      :navigation-size="5"
    ></PageNavigation>
    <label for="검색">선택:</label>
    <select id="select" v-model="selectedArticle" name="cars">
      <option value="userid">아이디검색</option>
      <option value="subject">제목검색</option>
    </select>

    <input v-model="searchArticleMessage" placeholder="" />
    <button v-on:click="searchArticle">검색</button>
  </div>
</template>

<style scoped>
.article-item:hover {
  background-color: aquamarine;
}
</style>
