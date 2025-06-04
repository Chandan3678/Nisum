let selectedRating1 = 0;
function DeliveryFeedback() {
  const modal = document.getElementById("dfModal");
  const stars = modal.querySelectorAll(".star");
  const textarea = modal.querySelector("textarea");
  stars.forEach(star => {
    star.innerHTML = "&#9733;";
    star.classList.remove("selected");
  });
  textarea.value = "";
  modal.style.display = "block";
}
function closeDeliveryFeedback() {
  document.getElementById("dfModal").style.display = "none";
}
document.querySelectorAll(".star").forEach(star => {
  star.addEventListener("click", function () {
    selectedRating1 = this.getAttribute("data-value");
    highlightStars(selectedRating1);
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
function submitdf() {
  const feedback = document.getElementById("dfeedbackText").value;
  if (!selectedRating1 || !feedback.trim()) {
    alert("Please provide a rating and write some feedback about the Product.");
    return;
  }
  alert(`Thankyou for your respons.`);
  closeDeliveryFeedback();
}
