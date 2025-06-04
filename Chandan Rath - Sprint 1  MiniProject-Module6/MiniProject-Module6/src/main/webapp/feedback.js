let selectedRating = 0;

function openFeedback() {
  const modal = document.getElementById("feedbackModal");
  const stars = modal.querySelectorAll(".star");
  const textarea = modal.querySelector("textarea");
  stars.forEach(star => {
    star.innerHTML = "&#9733;";
    star.classList.remove("selected");
  });
  textarea.value = "";
  modal.style.display = "block";
}
function closeFeedback() {
  document.getElementById("feedbackModal").style.display = "none";
}
document.querySelectorAll(".star").forEach(star => {
  star.addEventListener("click", function () {
    selectedRating = this.getAttribute("data-value");
    highlightStars(selectedRating);
  });
});
function highlightStars(rating) {
  document.querySelectorAll(".star").forEach(star => {
    star.classList.remove("selected");
    if (parseInt(star.getAttribute("data-value")) <= rating) {
      star.classList.add("selected");
    }
  });
}
function submitFeedback() {
  const feedback = document.getElementById("feedbackText").value;
  if (!selectedRating || !feedback.trim()) {
    alert("Please provide a rating and write some feedback.");
    return;
  }
  alert(`Thank you!`);
  closeFeedback();
}
