async function runTasksSequentially(tasks) {
  const results = [];

  for (const task of tasks) {
    try {
      const result = await task();
      results.push(result);
    } catch (error) {
      console.error(error);
    }
  }

  return results;
}

const tasks = [
  () => Promise.resolve('Download completed'),
  () => Promise.reject('Network error occurred'),
  () => Promise.resolve('Image processed'),
  () => Promise.reject('File not found'),
  () => Promise.resolve('Upload successful')
];

runTasksSequentially(tasks).then((results) => {
  console.log('Final Results:', results);
});
