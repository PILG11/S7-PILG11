const genSummary = (action, text) =>
  `<details><summary>show ${action} output</summary>

  \`\`\`diff
  ${text}
  \`\`\`

  </details>\n\n`;

module.exports = (action, require) => {
  const output = process.env.GITHUB_STEP_SUMMARY

  const fs = require('fs')
  const text = fs.readFileSync(action + '.txt')
  const summary = genSummary(action, text)
  fs.appendFileSync(output, summary)
}
