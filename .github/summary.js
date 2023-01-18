const genSummary = (text) =>
  `<details><summary>list all backup</summary>

  \`\`\`diff
  ${text}
  \`\`\`

  </details>\n\n`;

module.exports = (require) => {
  const output = process.env.GITHUB_STEP_SUMMARY

  const fs = require('fs')
  const text = fs.readFileSync('.txt')
  const summary = genSummary(text)
  fs.appendFileSync(output, summary)
}