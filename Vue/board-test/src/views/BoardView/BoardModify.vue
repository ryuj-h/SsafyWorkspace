<script setup>
import { RouterLink, useRoute, useRouter } from "vue-router";
import axios from "axios";
import { ref } from "vue";
//articleNo를 얻어와야 함

const router = useRouter();
const route = useRoute();
const article = ref({});

//@click="moveDetail(article.articleNo)"
const getArticle = async () => {
  //console.log(route);
  const url = "http://localhost/vue/board/" + route.params.articleNo;
  try {
    const response = await axios.get(url);
    article.value = response.data;
    console.log("응답 : ", response);
  } catch {
    console.log("에러 내용 : ", error);
  }
};

getArticle();
</script>
<template>
  <div>
    <h1>boardModify</h1>
    <!-- 목록 화면 이동 -->
  </div>
</template>

<style scoped></style>
