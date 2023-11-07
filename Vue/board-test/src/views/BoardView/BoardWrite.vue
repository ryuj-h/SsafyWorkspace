<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const articleForm = ref({
  userId: "ssafy",
  subject: "",
  content: "",
});

const router = useRouter();

// 등록 요청 보내고 등록 성공 시 목록 페이지 이동
const write = async () => {
  const url = "http://localhost:80/vue/board";
  try {
    const response = await axios.post(url, articleForm.value);
    console.log("응답 : ", response);
    alert("등록 성공");

    // vue-router의 useRouter를 import해서 useRouter()메서드로 만든 route 변수
    router.push("/board/list");
  } catch {
    console.log("에러 내용 : ", error);
    alert("등록 실패");
  }
};
</script>

<template>
  <div>
    <h1>게시글 등록</h1>
    <form @submit.prevent="write">
      <label
        ><input
          type="text"
          v-model.trim="articleForm.subject"
          required
        />제목</label
      >
      <br />
      <textarea
        cols="30"
        rows="10"
        v-model="articleForm.content"
        required
      ></textarea>
      <button>등록</button>
    </form>
  </div>
</template>

<style scoped></style>
