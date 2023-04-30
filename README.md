<a href="LICENSE.md">
<img src="https://unlicense.org/pd-icon.png" alt="Public Domain" align="right"/>
</a>

# Sekwences

[![build](https://github.com/binkley/sekwences/workflows/build/badge.svg)](https://github.com/binkley/sekwences/actions)
[![issues](https://img.shields.io/github/issues/binkley/sekwences.svg)](https://github.com/binkley/sekwences/issues/)
[![pull requests](https://img.shields.io/github/issues-pr/binkley/sekwences.svg)](https://github.com/binkley/sekwences/pulls)
[![vulnerabilities](https://snyk.io/test/github/binkley/sekwences/badge.svg)](https://snyk.io/test/github/binkley/sekwences)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

Explore various math sequences in Kotlin.

## Build and try

To build, use `./mvnw clean verify`.
Try `./run` for a demonstration.

To build as CI would, use `./batect build`.
Try `./batect run` for a demonstration as CI would.

This project assumes JDK 17.
There are no run-time dependencies beyond the Kotlin standard library.

## Sequences

### "Flip-flop"

"Flip-flop" refers to a sequence defined as:

* Given a maximum (cap) value, `M`
* Given a starting value (seed), `a1` less than `M`
* Given a function, `f`, such that `a[n+1] = f(a[n])`

Each sequence value `a[n+1]` is `f(a[n])` until exceeding `M`.
Then the _excess_ of `f(a[n])` over `M` is subtracted from `M` and, and that
result is `a[n+1]`.

Assume that `M`, `a1`, and the result of `f` are non-negative integers, and
that `a1` and the result of `f` are bounded by `0 <= value <= M`.

Present code explores `M` equal to 100, and `f` equal to `2n` (doubling the
previous value).

Questions to explore:
- Do all values for `a1` result in cycles?
- What are "prime" cycles? That is, are there unique portions of cycles for
  all `a[n]` such that every cycle eventuall joins these?
- How does changing `M` change cycles?
- What functions `f` produce cycles given the assumptions?
- What functions `f` produce cycles when relaxing assumptions?
- What combinations of `M`, `a1`, and `f` maximize or minimize cycle lenghths?
