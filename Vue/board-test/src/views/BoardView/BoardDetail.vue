<script setup>
import { RouterLink, useRoute, useRouter } from "vue-router";
import axios from "axios";
import { ref } from "vue";
//articleNo를 얻어와야 함

const router = useRouter();
const route = useRoute();
const article = ref({});
//console.log(route);
//console.log(route.params.articleNo);
const getArticle = async () => {
  const url = "http://localhost/vue/board/" + route.params.articleNo;
  try {
    const response = await axios.get(url);
    article.value = response.data;
    console.log("응답 : ", response);
  } catch {
    console.log("에러 내용 : ", error);
  }
};

const moveToModify = (articleNo) => {
  router.push("/board/modify/" + articleNo);
  /*router.push({
    name: "article-modify",
    params: { articleNo: articleNo },
  });*/
};

const moveToList = async () => {
  router.push("/board/list");
};

const deleteArticle = async (articleNo) => {
  if (!confirm("정말 삭제하시겠습니까?")) return;
  const url = `http://localhost/vue/board/${article.value.value.article.No}`;
  const response = await axios.delete(url);
  console.log("삭제 응답", response);
};

getArticle();
</script>
<template>
  <div>
    <h1>boardDetail</h1>
    <table>
      <tr>
        <th>글 번호</th>
        <th>글 제목</th>
        <th>글 내용</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>작성자</th>
      </tr>
      <tr>
        <th>{{ article.articleNo }}</th>
        <th>{{ article.subject }}</th>
        <th>{{ article.hit }}</th>
        <th>{{ article.registerTime }}</th>
        <th>{{ article.userName }}</th>
      </tr>
      <p>글 내용 : {{ article.content }}</p>
    </table>
    <!-- 수정 화면 이동 -->

    <form @submit.prevent="moveToModify(article.articleNo)">
      <button>수정</button>
    </form>
    <!--<RouterLink :to="{ name: 'article-modify' }">수정</RouterLink>-->
    <!-- 목록 화면 이동 -->
    <!--<RouterLink :to="{ name: 'board/list' }">목록</RouterLink>-->
    <form @submit.prevent="moveToList()">
      <button>목록</button>
    </form>

    <button @click="$click = deleteArticle(article.articleNo)">삭제</button>
  </div>
</template>

<style scoped></style>
